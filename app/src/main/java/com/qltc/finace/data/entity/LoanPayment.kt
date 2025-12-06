package com.qltc.finace.data.entity

import android.os.Parcelable
import com.qltc.finace.extension.toLocalDate
import com.qltc.finace.extension.toMonthYearString
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoanPayment(
    var idPayment: String? = null,
    var idLoan: String? = null,
    var idUser: String? = null,
    var amount: Long? = null,
    var date: String? = null,
    var note: String? = null
) : Parcelable {

    fun getYearMonth() = date.toLocalDate().toMonthYearString()
}