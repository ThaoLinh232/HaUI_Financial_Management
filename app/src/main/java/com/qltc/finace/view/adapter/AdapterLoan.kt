package com.qltc.finace.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.qltc.finace.R
import com.qltc.finace.data.entity.Loan
import com.qltc.finace.databinding.ItemListLoanBinding
import java.text.NumberFormat
import java.util.Locale

class AdapterLoan(
    private val onClickListener: OnClickListener
) : ListAdapter<Loan, AdapterLoan.LoanViewHolder>(Callback()) {

    private val numberFormat by lazy {
        NumberFormat.getNumberInstance(Locale("vi", "VN")).apply {
            maximumFractionDigits = 0
        }
    }

    class LoanViewHolder(val binding: ItemListLoanBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(loan: Loan, numberFormat: NumberFormat) {
            binding.apply {
                // Tên khoản vay
                tvLoanTitle.text = loan.title ?: "Khoản vay"

                // Tổng tiền
                tvTotal.text = "Tổng: ${numberFormat.format(loan.amount ?: 0L)} đ"

                // Kỳ hạn (tính từ date đến dueDate)
                val term = calculateTerm(loan.date, loan.dueDate)
                tvTerm.text = "Kỳ: $term"

                // Đã trả
                tvPaid.text = "Đã trả: ${numberFormat.format(loan.paidAmount ?: 0L)}đ"

                // Còn lại
                val remaining = loan.getRemainingAmount()
                tvRemaining.text = "Còn lại: ${numberFormat.format(remaining)}đ"

                // Trạng thái
                val statusText = when (loan.status) {
                    Loan.STATUS_PAID -> "[Đã trả hết]"
                    Loan.STATUS_OVERDUE -> "[Quá hạn]"
                    else -> "[Đang vay]"
                }
                tvStatusValue.text = statusText

                // Màu trạng thái
                val statusColor = when (loan.status) {
                    Loan.STATUS_PAID -> R.color.green_text
                    Loan.STATUS_OVERDUE -> R.color.red_d61c1c
                    else -> R.color.orange
                }
                tvStatusValue.setTextColor(binding.root.context.getColor(statusColor))
            }
        }

        private fun calculateTerm(dateStart: String?, dateEnd: String?): String {
            if (dateStart == null || dateEnd == null) return "Không xác định"

            try {
                val formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")
                val start = java.time.LocalDate.parse(dateStart, formatter)
                val end = java.time.LocalDate.parse(dateEnd, formatter)

                val months = java.time.Period.between(start, end).toTotalMonths()
                return if (months > 0) {
                    "$months tháng"
                } else {
                    val days = java.time.temporal.ChronoUnit.DAYS.between(start, end)
                    "$days ngày"
                }
            } catch (e: Exception) {
                return "Không xác định"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoanViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemListLoanBinding>(
            inflater,
            R.layout.item_list_loan,
            parent,
            false
        )
        return LoanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LoanViewHolder, position: Int) {
        val loan = getItem(position)
        holder.bind(loan, numberFormat)
        holder.itemView.setOnClickListener {
            onClickListener.onClickLoanItem(loan)
        }
    }

    class Callback : DiffUtil.ItemCallback<Loan>() {
        override fun areItemsTheSame(oldItem: Loan, newItem: Loan): Boolean {
            return oldItem.idLoan == newItem.idLoan
        }

        override fun areContentsTheSame(oldItem: Loan, newItem: Loan): Boolean {
            return oldItem == newItem
        }
    }

    interface OnClickListener {
        fun onClickLoanItem(loan: Loan)
    }
}