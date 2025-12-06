package com.qltc.finace.data

import com.qltc.finace.data.entity.Category
import com.qltc.finace.data.entity.Expense
import com.qltc.finace.data.entity.Income
import com.google.firebase.firestore.DocumentSnapshot
import com.qltc.finace.data.entity.Loan
import com.qltc.finace.data.entity.LoanPayment

fun DocumentSnapshot.mapperCategory(typeCategory: String) : Category {
    return Category(
        idCategory = this.id,
        icon = this["icon"] as? String?,
        title = this["title"] as? String,
        type = this["type"] as? String ?: typeCategory
    )
}
fun DocumentSnapshot.mapperExpense() : Expense {
    return Expense(
        idExpense = this.id,
        idCategory = this["idCategory"] as? String?,
        idUser = this["idUser"] as? String?,
        expense = this["expense"] as? Long?,
        note = this["note"] as? String?,
        date = this["date"] as? String
    )
}
fun DocumentSnapshot.mapperIncome() : Income {
    return Income(
        idIncome = this.id,
        idCategory = this["idCategory"] as? String?,
        idUser = this["idUser"] as? String?,
        income = this["income"] as? Long?,
        date = this["date"] as? String?,
        note = this["note"] as? String?
    )
}
fun DocumentSnapshot.mapperLoan() : Loan {
    return Loan(
        idLoan = this.id,
        idUser = this["idUser"] as? String?,
        loanType = this["loanType"] as? String?,
        amount = this["amount"] as? Long?,
        paidAmount = this["paidAmount"] as? Long?,
        title = this["title"] as? String?,
        note = this["note"] as? String?,
        date = this["date"] as? String?,
        dueDate = this["dueDate"] as? String?,
        status = this["status"] as? String?
    )
}

fun DocumentSnapshot.mapperLoanPayment() : LoanPayment {
    return LoanPayment(
        idPayment = this.id,
        idLoan = this["idLoan"] as? String?,
        idUser = this["idUser"] as? String?,
        amount = this["amount"] as? Long?,
        date = this["date"] as? String?,
        note = this["note"] as? String?
    )
}