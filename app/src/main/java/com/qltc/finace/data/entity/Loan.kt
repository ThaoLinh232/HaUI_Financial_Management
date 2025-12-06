package com.qltc.finace.data.entity

import android.os.Parcelable
import com.qltc.finace.extension.toLocalDate
import com.qltc.finace.extension.toMonthYearString
import kotlinx.parcelize.Parcelize

@Parcelize
data class Loan(
    var idLoan: String? = null,
    var idUser: String? = null,
    var loanType: String? = null, // "BORROW", "LEND", "DEBT_COLLECTION", "PAY_DEBT"
    var amount: Long? = null, // Tổng tiền
    var paidAmount: Long? = null, // Đã trả
    var title: String? = null, // Tên khoản vay (VD: "Khoản vay A")
    var note: String? = null,
    var date: String? = null, // Ngày tạo
    var dueDate: String? = null, // Ngày trả dự kiến
    var status: String? = null, // "ONGOING", "PAID", "OVERDUE"
) : Parcelable {

    companion object {
        const val TYPE_BORROW = "BORROW" // Đi vay
        const val TYPE_LEND = "LEND" // Cho vay
        const val TYPE_DEBT_COLLECTION = "DEBT_COLLECTION" // Thu nợ
        const val TYPE_PAY_DEBT = "PAY_DEBT" // Trả nợ

        const val STATUS_ONGOING = "ONGOING" // Đang vay
        const val STATUS_PAID = "PAID" // Đã trả hết
        const val STATUS_OVERDUE = "OVERDUE" // Quá hạn
    }

    fun getYearMonth() = date.toLocalDate().toMonthYearString()

    fun getRemainingAmount(): Long {
        return (amount ?: 0L) - (paidAmount ?: 0L)
    }

    fun isOverdue(): Boolean {
        if (status == STATUS_PAID) return false
        dueDate?.let {
            return it.toLocalDate().isBefore(java.time.LocalDate.now())
        }
        return false
    }

    fun getProgressPercent(): Int {
        val total = amount ?: 0L
        val paid = paidAmount ?: 0L
        if (total == 0L) return 0
        return ((paid.toDouble() / total.toDouble()) * 100).toInt()
    }
}