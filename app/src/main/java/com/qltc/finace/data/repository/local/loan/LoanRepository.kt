package com.qltc.finace.data.repository.local.loan

import com.qltc.finace.data.entity.Loan
import com.qltc.finace.data.entity.LoanPayment

interface LoanRepository {

    // ===== LOAN CRUD =====
    suspend fun getAllLoans(): MutableList<Loan>

    suspend fun getLoanById(idLoan: String): Loan?

    suspend fun getLoansByMonth(month: String): List<Loan>

    suspend fun getLoansByType(loanType: String): List<Loan>

    suspend fun insertLoan(loan: Loan): Boolean

    suspend fun updateLoan(loan: Loan): Boolean

    suspend fun deleteLoan(loan: Loan): Boolean

    // ===== LOAN PAYMENT CRUD =====
    suspend fun getAllPaymentsByLoan(idLoan: String): MutableList<LoanPayment>

    suspend fun insertLoanPayment(payment: LoanPayment): Boolean

    suspend fun deleteLoanPayment(payment: LoanPayment): Boolean

    // ===== BUSINESS LOGIC =====
    suspend fun makePayment(idLoan: String, amount: Long, date: String, note: String? = null): Boolean
}