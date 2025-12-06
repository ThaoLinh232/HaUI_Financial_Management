package com.qltc.finace.view.main.wallet.add

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.qltc.finace.data.entity.Loan
import com.qltc.finace.databinding.ItemLoanSelectorBinding
import java.text.NumberFormat
import java.util.*

class LoanSourceAdapter(
    private val onLoanSelected: (Loan) -> Unit
) : ListAdapter<Loan, LoanSourceAdapter.LoanViewHolder>(LoanDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoanViewHolder {
        val binding = ItemLoanSelectorBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LoanViewHolder(binding, onLoanSelected)
    }

    override fun onBindViewHolder(holder: LoanViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LoanViewHolder(
        private val binding: ItemLoanSelectorBinding,
        private val onLoanSelected: (Loan) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(loan: Loan) {
            val numberFormat = NumberFormat.getNumberInstance(Locale("vi", "VN"))
            
            binding.tvLoanTitle.text = loan.title ?: "Không có tên"
            binding.tvLoanAmount.text = "Tổng: ${numberFormat.format(loan.amount ?: 0)} đ"
            binding.tvLoanRemaining.text = "Còn lại: ${numberFormat.format(loan.getRemainingAmount())} đ"
            
            binding.root.setOnClickListener {
                onLoanSelected(loan)
            }
        }
    }

    private class LoanDiffCallback : DiffUtil.ItemCallback<Loan>() {
        override fun areItemsTheSame(oldItem: Loan, newItem: Loan): Boolean {
            return oldItem.idLoan == newItem.idLoan
        }

        override fun areContentsTheSame(oldItem: Loan, newItem: Loan): Boolean {
            return oldItem == newItem
        }
    }
}
