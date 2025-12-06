package com.qltc.finace.data.repository.local.loan

import android.util.Log
import com.qltc.finace.data.Fb
import com.qltc.finace.data.entity.Loan
import com.qltc.finace.data.entity.LoanPayment
import com.qltc.finace.extension.toLocalDate
import com.qltc.finace.extension.toMonthYearString
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LoanRepositoryImp @Inject constructor() : LoanRepository {

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

        db.collection(Fb.Loan)
            .add(loan)
            .addOnSuccessListener {
                result = true
                Log.d("LoanRepository", "insertLoan success")
            }
            .addOnFailureListener { e ->
                result = false
                Log.e("LoanRepository", "insertLoan failed: ${e.message}")
            }
            .await()

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

        // 3. Cập nhật paidAmount và status của Loan
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
}