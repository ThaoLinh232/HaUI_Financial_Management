package com.qltc.finace.data.repository.local.loan

import android.util.Log
import com.qltc.finace.data.Fb
import com.qltc.finace.data.entity.Loan
import com.qltc.finace.data.entity.LoanPayment
import com.qltc.finace.data.entity.Income
import com.qltc.finace.data.entity.Expense
import com.qltc.finace.data.repository.local.income.InComeRepository
import com.qltc.finace.data.repository.local.expense.ExpenseRepository
import com.qltc.finace.extension.toLocalDate
import com.qltc.finace.extension.toMonthYearString
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LoanRepositoryImp @Inject constructor(
    private val incomeRepository: InComeRepository,
    private val expenseRepository: ExpenseRepository
) : LoanRepository {

    private val db: FirebaseFirestore = Firebase.firestore
    private val user by lazy { FirebaseAuth.getInstance().currentUser }

    // ===== LOAN CRUD =====

    override suspend fun getAllLoans(): MutableList<Loan> {
        if (user == null) return mutableListOf()

        return try {
            val querySnapshot = db.collection(Fb.Loan)
                .whereEqualTo(Fb.LoanField.idUser, user!!.uid)
                .get()
                .await()

            querySnapshot.documents.mapNotNull { document ->
                document.toObject(Loan::class.java)?.apply {
                    idLoan = document.id
                }
            }.toMutableList()
        } catch (e: Exception) {
            Log.e("LoanRepository", "getAllLoans failed: ${e.message}")
            mutableListOf()
        }
    }

    override suspend fun getLoanById(idLoan: String): Loan? {
        if (user == null) {
            Log.e("LoanRepository", "getLoanById: User is null")
            return null
        }

        Log.d("LoanRepository", "getLoanById: Fetching loan with ID: $idLoan for user: ${user!!.uid}")
        var loan: Loan? = null
        
        try {
            // Use query with idUser filter to satisfy Firestore rules
            val querySnapshot = db.collection(Fb.Loan)
                .whereEqualTo(Fb.LoanField.idUser, user!!.uid)
                .get()
                .await()
            
            // Find the document with matching ID
            val document = querySnapshot.documents.find { it.id == idLoan }
            
            if (document != null && document.exists()) {
                Log.d("LoanRepository", "getLoanById: Document found")
                loan = document.toObject(Loan::class.java)
                loan?.idLoan = document.id
                Log.d("LoanRepository", "getLoanById: Loan loaded - title: ${loan?.title}, amount: ${loan?.amount}")
            } else {
                Log.e("LoanRepository", "getLoanById: Document not found with ID: $idLoan")
            }
        } catch (e: Exception) {
            Log.e("LoanRepository", "getLoanById failed: ${e.message}", e)
        }

        return loan
    }

    override suspend fun getLoansByMonth(month: String): List<Loan> {
        if (user == null) return mutableListOf()

        return try {
            val querySnapshot = db.collection(Fb.Loan)
                .whereEqualTo(Fb.LoanField.idUser, user!!.uid)
                .get()
                .await()

            querySnapshot.documents.mapNotNull { doc ->
                doc.toObject(Loan::class.java)?.apply {
                    idLoan = doc.id
                }
            }.filter { loan ->
                loan.date?.toLocalDate()?.toMonthYearString() == month
            }.toMutableList()
        } catch (e: Exception) {
            Log.e("LoanRepository", "getLoansByMonth failed: ${e.message}")
            mutableListOf()
        }
    }

    override suspend fun getLoansByType(loanType: String): List<Loan> {
        if (user == null) return mutableListOf()

        return try {
            val querySnapshot = db.collection(Fb.Loan)
                .whereEqualTo(Fb.LoanField.idUser, user!!.uid)
                .whereEqualTo(Fb.LoanField.loanType, loanType)
                .get()
                .await()

            querySnapshot.documents.mapNotNull { document ->
                document.toObject(Loan::class.java)?.apply {
                    idLoan = document.id
                }
            }.toMutableList()
        } catch (e: Exception) {
            Log.e("LoanRepository", "getLoansByType failed: ${e.message}")
            mutableListOf()
        }
    }

    override suspend fun insertLoan(loan: Loan): Boolean {
        if (user == null) return false

        loan.idUser = user!!.uid
        loan.paidAmount = loan.paidAmount ?: 0L

        return try {
            // Thêm loan vào Firestore
            val documentReference = db.collection(Fb.Loan)
                .add(loan)
                .await()

            loan.idLoan = documentReference.id
            Log.d("LoanRepository", "insertLoan success: ${loan.idLoan}")

            // Tự động tạo Income hoặc Expense tương ứng
            createTransactionFromLoan(loan)

            true
        } catch (e: Exception) {
            Log.e("LoanRepository", "insertLoan failed: ${e.message}")
            false
        }
    }

    override suspend fun updateLoan(loan: Loan): Boolean {
        if (user == null || loan.idLoan == null) return false

        return try {
            db.collection(Fb.Loan)
                .document(loan.idLoan!!)
                .update(
                    mapOf(
                        "idUser" to loan.idUser,
                        "loanType" to loan.loanType,
                        "amount" to loan.amount,
                        "paidAmount" to loan.paidAmount,
                        "title" to loan.title,
                        "note" to loan.note,
                        "date" to loan.date,
                        "dueDate" to loan.dueDate,
                        "status" to loan.status
                    )
                )
                .await()

            Log.d("LoanRepository", "updateLoan success")
            true
        } catch (e: Exception) {
            Log.e("LoanRepository", "updateLoan failed: ${e.message}")
            false
        }
    }

    override suspend fun deleteLoan(loan: Loan): Boolean {
        if (user == null || loan.idLoan == null) return false

        return try {
            // Xóa tất cả payments liên quan trước
            val payments = getAllPaymentsByLoan(loan.idLoan!!)
            payments.forEach { payment ->
                deleteLoanPayment(payment)
            }

            // Sau đó xóa loan
            db.collection(Fb.Loan)
                .document(loan.idLoan!!)
                .delete()
                .await()

            Log.d("LoanRepository", "deleteLoan success")
            true
        } catch (e: Exception) {
            Log.e("LoanRepository", "deleteLoan failed: ${e.message}")
            false
        }
    }

    // ===== LOAN PAYMENT CRUD =====

    override suspend fun getAllPaymentsByLoan(idLoan: String): MutableList<LoanPayment> {
        if (user == null) {
            Log.e("LoanRepository", "getAllPaymentsByLoan: User is null")
            return mutableListOf()
        }

        Log.d("LoanRepository", "getAllPaymentsByLoan: Fetching payments for loan: $idLoan")
        val listPayment = mutableListOf<LoanPayment>()
        
        try {
            val querySnapshot = db.collection(Fb.LoanPayment)
                .whereEqualTo("idUser", user!!.uid)  // MUST filter by idUser first for Firestore rules
                .whereEqualTo("idLoan", idLoan)      // Then filter by idLoan
                .get()
                .await()
            
            querySnapshot.documents.forEach { document ->
                document.toObject(LoanPayment::class.java)?.let { payment ->
                    payment.idPayment = document.id
                    listPayment.add(payment)
                }
            }
            Log.d("LoanRepository", "getAllPaymentsByLoan: Found ${listPayment.size} payments")
        } catch (e: Exception) {
            Log.e("LoanRepository", "getAllPaymentsByLoan failed: ${e.message}", e)
        }

        return listPayment
    }

    override suspend fun insertLoanPayment(payment: LoanPayment): Boolean {
        if (user == null) return false

        payment.idUser = user!!.uid

        return try {
            db.collection(Fb.LoanPayment)
                .add(payment)
                .await()

            Log.d("LoanRepository", "insertLoanPayment success")
            true
        } catch (e: Exception) {
            Log.e("LoanRepository", "insertLoanPayment failed: ${e.message}")
            false
        }
    }

    override suspend fun deleteLoanPayment(payment: LoanPayment): Boolean {
        if (user == null || payment.idPayment == null) return false

        return try {
            db.collection(Fb.LoanPayment)
                .document(payment.idPayment!!)
                .delete()
                .await()

            Log.d("LoanRepository", "deleteLoanPayment success")
            true
        } catch (e: Exception) {
            Log.e("LoanRepository", "deleteLoanPayment failed: ${e.message}")
            false
        }
    }

    // ===== BUSINESS LOGIC =====

    override suspend fun makePayment(
        idLoan: String,
        amount: Long,
        date: String,
        note: String?
    ): Boolean {
        if (user == null) return false

        // 1. Lấy thông tin loan hiện tại
        val loan = getLoanById(idLoan) ?: return false

        // 2. Tạo LoanPayment mới
        val payment = LoanPayment(
            idLoan = idLoan,
            idUser = user!!.uid,
            amount = amount,
            date = date,
            note = note
        )

        val paymentSuccess = insertLoanPayment(payment)
        if (!paymentSuccess) return false

        // 3. Tự động tạo giao dịch Income/Expense khi thanh toán
        createTransactionFromPayment(loan, amount, date, note)

        // 4. Cập nhật paidAmount và status của Loan
        val newPaidAmount = (loan.paidAmount ?: 0L) + amount
        val newStatus = if (newPaidAmount >= (loan.amount ?: 0L)) {
            Loan.STATUS_PAID
        } else {
            Loan.STATUS_ONGOING
        }

        loan.paidAmount = newPaidAmount
        loan.status = newStatus

        return updateLoan(loan)
    }

    // ===== HELPER FUNCTIONS =====

    /**
     * Tự động tạo Income hoặc Expense dựa trên loại Loan khi tạo mới Loan
     *
     * Logic:
     * - TYPE_LEND (Cho vay) -> Tạo Expense (Tiền ra)
     * - TYPE_DEBT_COLLECTION (Thu nợ) -> Tạo Income (Tiền vào)
     * - TYPE_BORROW (Đi vay) -> Tạo Income (Tiền vào)
     * - TYPE_PAY_DEBT (Trả nợ) -> Tạo Expense (Tiền ra)
     */
    private suspend fun createTransactionFromLoan(loan: Loan) {
        val transactionNote = buildString {
            append(getTypeName(loan.loanType))
            append(": ")
            append(loan.title ?: "")
            if (!loan.note.isNullOrEmpty()) {
                append(" - ")
                append(loan.note)
            }
        }

        when (loan.loanType) {
            Loan.TYPE_LEND -> {
                // Cho vay -> Tạo Expense (tiền ra khỏi ví)
                val expense = Expense(
                    idUser = loan.idUser,
                    idCategory = null, // TODO: Lấy ID category "Cho vay"
                    expense = loan.amount,
                    note = transactionNote,
                    date = loan.date
                )
                val success = expenseRepository.insertExpense(expense)
                Log.d("LoanRepository", "Auto create Expense for LEND: $success")
            }

            Loan.TYPE_DEBT_COLLECTION -> {
                // Thu nợ -> Tạo Income (tiền vào ví)
                val income = Income(
                    idUser = loan.idUser,
                    idCategory = null, // TODO: Lấy ID category "Thu nợ"
                    income = loan.amount,
                    note = transactionNote,
                    date = loan.date
                )
                val success = incomeRepository.insertIncome(income)
                Log.d("LoanRepository", "Auto create Income for DEBT_COLLECTION: $success")
            }

            Loan.TYPE_BORROW -> {
                // Đi vay -> Tạo Income (tiền vào ví)
                val income = Income(
                    idUser = loan.idUser,
                    idCategory = null, // TODO: Lấy ID category "Đi vay"
                    income = loan.amount,
                    note = transactionNote,
                    date = loan.date
                )
                val success = incomeRepository.insertIncome(income)
                Log.d("LoanRepository", "Auto create Income for BORROW: $success")
            }

            Loan.TYPE_PAY_DEBT -> {
                // Trả nợ -> Tạo Expense (tiền ra khỏi ví)
                val expense = Expense(
                    idUser = loan.idUser,
                    idCategory = null, // TODO: Lấy ID category "Trả nợ"
                    expense = loan.amount,
                    note = transactionNote,
                    date = loan.date
                )
                val success = expenseRepository.insertExpense(expense)
                Log.d("LoanRepository", "Auto create Expense for PAY_DEBT: $success")
            }
        }
    }

    /**
     * Tự động tạo Income/Expense khi thanh toán Loan (makePayment)
     *
     * Logic:
     * - BORROW (Đi vay) -> Khi trả nợ tạo Expense (tiền ra)
     * - LEND (Cho vay) -> Khi thu nợ tạo Income (tiền vào)
     * - DEBT_COLLECTION (Thu nợ) -> Không cần tạo (đã tạo khi tạo loan)
     * - PAY_DEBT (Trả nợ) -> Không cần tạo (đã tạo khi tạo loan)
     */
    private suspend fun createTransactionFromPayment(
        loan: Loan,
        amount: Long,
        date: String,
        note: String?
    ) {
        when (loan.loanType) {
            Loan.TYPE_BORROW -> {
                // Trả tiền vay -> Expense (tiền ra)
                val paymentNote = buildString {
                    append("Trả nợ: ")
                    append(loan.title ?: "")
                    if (!note.isNullOrEmpty()) {
                        append(" - ")
                        append(note)
                    }
                }

                val expense = Expense(
                    idUser = loan.idUser,
                    idCategory = null, // TODO: Lấy ID category "Trả nợ"
                    expense = amount,
                    note = paymentNote,
                    date = date
                )
                val success = expenseRepository.insertExpense(expense)
                Log.d("LoanRepository", "Auto create Expense for BORROW payment: $success")
            }

            Loan.TYPE_LEND -> {
                // Thu tiền cho vay -> Income (tiền vào)
                val paymentNote = buildString {
                    append("Thu nợ: ")
                    append(loan.title ?: "")
                    if (!note.isNullOrEmpty()) {
                        append(" - ")
                        append(note)
                    }
                }

                val income = Income(
                    idUser = loan.idUser,
                    idCategory = null, // TODO: Lấy ID category "Thu nợ"
                    income = amount,
                    note = paymentNote,
                    date = date
                )
                val success = incomeRepository.insertIncome(income)
                Log.d("LoanRepository", "Auto create Income for LEND payment: $success")
            }

            else -> {
                Log.d("LoanRepository", "No auto transaction needed for ${loan.loanType} payment")
            }
        }
    }


    private fun getTypeName(loanType: String?): String {
        return when (loanType) {
            Loan.TYPE_DEBT_COLLECTION -> "Thu nợ"
            Loan.TYPE_LEND -> "Cho vay"
            Loan.TYPE_BORROW -> "Đi vay"
            Loan.TYPE_PAY_DEBT -> "Trả nợ"
            else -> "Khoản vay"
        }
    }
}