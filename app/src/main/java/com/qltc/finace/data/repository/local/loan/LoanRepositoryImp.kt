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

        val listLoan = mutableListOf<Loan>()
        db.collection(Fb.Loan)
            .whereEqualTo(Fb.LoanField.idUser, user!!.uid)
            .get()
            .addOnSuccessListener { querySnapshot ->
                querySnapshot.documents.forEach { document ->
                    document.toObject(Loan::class.java)?.let { loan ->
                        loan.idLoan = document.id
                        listLoan.add(loan)
                    }
                }
            }
            .addOnFailureListener { e ->
                Log.e("LoanRepository", "getAllLoans failed: ${e.message}")
            }
            .await()

        return listLoan
    }

    override suspend fun getLoanById(idLoan: String): Loan? {
        if (user == null) return null

        var loan: Loan? = null
        db.collection(Fb.Loan)
            .document(idLoan)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    loan = document.toObject(Loan::class.java)
                    loan?.idLoan = document.id
                }
            }
            .addOnFailureListener { e ->
                Log.e("LoanRepository", "getLoanById failed: ${e.message}")
            }
            .await()

        return loan
    }

    override suspend fun getLoansByMonth(month: String): List<Loan> {
        if (user == null) return mutableListOf()

        val listLoan = mutableListOf<Loan>()
        db.collection(Fb.Loan)
            .whereEqualTo(Fb.LoanField.idUser, user!!.uid)
            .get()
            .addOnSuccessListener { querySnapshot ->
                for (doc in querySnapshot.documents) {
                    val loan = doc.toObject(Loan::class.java)
                    loan?.idLoan = doc.id
                    if (loan != null && loan.date?.toLocalDate()?.toMonthYearString() == month) {
                        listLoan.add(loan)
                    }
                }
            }
            .addOnFailureListener { e ->
                Log.e("LoanRepository", "getLoansByMonth failed: ${e.message}")
            }
            .await()

        return listLoan
    }

    override suspend fun getLoansByType(loanType: String): List<Loan> {
        if (user == null) return mutableListOf()

        val listLoan = mutableListOf<Loan>()
        db.collection(Fb.Loan)
            .whereEqualTo(Fb.LoanField.idUser, user!!.uid)
            .whereEqualTo(Fb.LoanField.loanType, loanType)
            .get()
            .addOnSuccessListener { querySnapshot ->
                querySnapshot.documents.forEach { document ->
                    document.toObject(Loan::class.java)?.let { loan ->
                        loan.idLoan = document.id
                        listLoan.add(loan)
                    }
                }
            }
            .addOnFailureListener { e ->
                Log.e("LoanRepository", "getLoansByType failed: ${e.message}")
            }
            .await()

        return listLoan
    }

    override suspend fun insertLoan(loan: Loan): Boolean {
        if (user == null) return false

        var result = false
        loan.idUser = user!!.uid
        loan.paidAmount = loan.paidAmount ?: 0L

        // Thêm loan vào Firestore
        db.collection(Fb.Loan)
            .add(loan)
            .addOnSuccessListener { documentReference ->
                result = true
                loan.idLoan = documentReference.id
                Log.d("LoanRepository", "insertLoan success: ${loan.idLoan}")
            }
            .addOnFailureListener { e ->
                result = false
                Log.e("LoanRepository", "insertLoan failed: ${e.message}")
            }
            .await()

        // Tự động tạo Income hoặc Expense tương ứng
        if (result) {
            createTransactionFromLoan(loan)
        }

        return result
    }

    override suspend fun updateLoan(loan: Loan): Boolean {
        if (user == null || loan.idLoan == null) return false

        var result = false
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
            .addOnSuccessListener {
                result = true
                Log.d("LoanRepository", "updateLoan success")
            }
            .addOnFailureListener { e ->
                result = false
                Log.e("LoanRepository", "updateLoan failed: ${e.message}")
            }
            .await()

        return result
    }

    override suspend fun deleteLoan(loan: Loan): Boolean {
        if (user == null || loan.idLoan == null) return false

        var result = false

        // Xóa tất cả payments liên quan trước
        val payments = getAllPaymentsByLoan(loan.idLoan!!)
        payments.forEach { payment ->
            deleteLoanPayment(payment)
        }

        // Sau đó xóa loan
        db.collection(Fb.Loan)
            .document(loan.idLoan!!)
            .delete()
            .addOnSuccessListener {
                result = true
                Log.d("LoanRepository", "deleteLoan success")
            }
            .addOnFailureListener { e ->
                result = false
                Log.e("LoanRepository", "deleteLoan failed: ${e.message}")
            }
            .await()

        return result
    }

    // ===== LOAN PAYMENT CRUD =====

    override suspend fun getAllPaymentsByLoan(idLoan: String): MutableList<LoanPayment> {
        if (user == null) return mutableListOf()

        val listPayment = mutableListOf<LoanPayment>()
        db.collection(Fb.LoanPayment)
            .whereEqualTo("idLoan", idLoan)
            .get()
            .addOnSuccessListener { querySnapshot ->
                querySnapshot.documents.forEach { document ->
                    document.toObject(LoanPayment::class.java)?.let { payment ->
                        payment.idPayment = document.id
                        listPayment.add(payment)
                    }
                }
            }
            .addOnFailureListener { e ->
                Log.e("LoanRepository", "getAllPaymentsByLoan failed: ${e.message}")
            }
            .await()

        return listPayment
    }

    override suspend fun insertLoanPayment(payment: LoanPayment): Boolean {
        if (user == null) return false

        var result = false
        payment.idUser = user!!.uid

        db.collection(Fb.LoanPayment)
            .add(payment)
            .addOnSuccessListener {
                result = true
                Log.d("LoanRepository", "insertLoanPayment success")
            }
            .addOnFailureListener { e ->
                result = false
                Log.e("LoanRepository", "insertLoanPayment failed: ${e.message}")
            }
            .await()

        return result
    }

    override suspend fun deleteLoanPayment(payment: LoanPayment): Boolean {
        if (user == null || payment.idPayment == null) return false

        var result = false
        db.collection(Fb.LoanPayment)
            .document(payment.idPayment!!)
            .delete()
            .addOnSuccessListener {
                result = true
                Log.d("LoanRepository", "deleteLoanPayment success")
            }
            .addOnFailureListener { e ->
                result = false
                Log.e("LoanRepository", "deleteLoanPayment failed: ${e.message}")
            }
            .await()

        return result
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