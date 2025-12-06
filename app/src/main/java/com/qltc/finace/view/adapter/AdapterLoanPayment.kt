package com.qltc.finace.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.qltc.finace.R
import com.qltc.finace.data.entity.LoanPayment
import com.qltc.finace.databinding.ItemTransactionBinding
import java.text.NumberFormat
import java.util.Locale

class AdapterLoanPayment : ListAdapter<LoanPayment, AdapterLoanPayment.PaymentViewHolder>(Callback()) {

    private val numberFormat by lazy {
        NumberFormat.getNumberInstance(Locale("vi", "VN")).apply {
            maximumFractionDigits = 0
        }
    }

    class PaymentViewHolder(val binding: ItemTransactionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(payment: LoanPayment, numberFormat: NumberFormat) {
            binding.apply {
                // Ngày trả
                tvDateLabel.text = "Ngày ${payment.date ?: ""}"

                // Số tiền
                tvAmount.text = "Số tiền: ${numberFormat.format(payment.amount ?: 0L)}đ"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemTransactionBinding>(
            inflater,
            R.layout.item_transaction,
            parent,
            false
        )
        return PaymentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val payment = getItem(position)
        holder.bind(payment, numberFormat)
    }

    class Callback : DiffUtil.ItemCallback<LoanPayment>() {
        override fun areItemsTheSame(oldItem: LoanPayment, newItem: LoanPayment): Boolean {
            return oldItem.idPayment == newItem.idPayment
        }

        override fun areContentsTheSame(oldItem: LoanPayment, newItem: LoanPayment): Boolean {
            return oldItem == newItem
        }
    }
}