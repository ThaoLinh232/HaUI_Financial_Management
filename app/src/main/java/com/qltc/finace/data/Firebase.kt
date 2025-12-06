package com.qltc.finace.data

import com.qltc.finace.data.entity.Category

// const Firebase
object Fb{
    const val User = "User"
    const val Income = "Income"
    const val Expense = "Expense"
    const val CategoryExpense = "CategoryExpense"
    const val CategoryIncome = "CategoryIncome"
    const val ItemAddedCategory = "Item_Added_At_Last_List_Category"
    const val Loan = "Loan"
    const val LoanPayment = "LoanPayment"
    object CategoryField {
        const val idUser = "idUser"
        const val idCategory = "idCategory"
    }
    object LoanField {
        const val idUser = "idUser"
        const val idLoan = "idLoan"
        const val loanType = "loanType"
        const val status = "status"
    }
    object ErrorCode {

    }
}