package com.qltc.finace.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.qltc.finace.R
import com.qltc.finace.databinding.ItemTransactionTypeBinding

data class TransactionType(
    val type: String,
    val title: String,
    val icon: String,
    var isSelected: Boolean = false
)

class AdapterTransactionType(
    private val onClickListener: OnClickListener
) : ListAdapter<TransactionType, AdapterTransactionType.TransactionTypeViewHolder>(Callback()) {

    private var selectedPosition = -1

    class TransactionTypeViewHolder(val binding: ItemTransactionTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TransactionType, isSelected: Boolean) {
            binding.apply {
                tvTitle.text = item.title
                tvIconSymbol.text = item.icon

                // Thay đổi màu khi được chọn
                val context = binding.root.context
                if (isSelected) {
                    cardIcon.setCardBackgroundColor(
                        ContextCompat.getColor(context, R.color.orange)
                    )
                    tvIconSymbol.setTextColor(
                        ContextCompat.getColor(context, R.color.white)
                    )
                    tvTitle.setTextColor(
                        ContextCompat.getColor(context, R.color.orange)
                    )
                    cardIcon.strokeColor = ContextCompat.getColor(context, R.color.orange)
                } else {
                    cardIcon.setCardBackgroundColor(
                        ContextCompat.getColor(context, R.color.white)
                    )
                    tvIconSymbol.setTextColor(
                        ContextCompat.getColor(context, R.color.black80)
                    )
                    tvTitle.setTextColor(
                        ContextCompat.getColor(context, R.color.black80)
                    )
                    cardIcon.strokeColor = ContextCompat.getColor(context, R.color.black80)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionTypeViewHolder {
        val binding = ItemTransactionTypeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TransactionTypeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionTypeViewHolder, position: Int) {
        val item = getItem(position)
        val isSelected = position == selectedPosition
        holder.bind(item, isSelected)

        holder.itemView.setOnClickListener {
            val previousPosition = selectedPosition
            selectedPosition = holder.adapterPosition

            // Notify changes
            if (previousPosition != -1) {
                notifyItemChanged(previousPosition)
            }
            notifyItemChanged(selectedPosition)

            onClickListener.onSelectTransactionType(item)
        }
    }

    fun setSelectedType(type: String) {
        val position = currentList.indexOfFirst { it.type == type }
        if (position != -1 && position != selectedPosition) {
            val previousPosition = selectedPosition
            selectedPosition = position

            if (previousPosition != -1) {
                notifyItemChanged(previousPosition)
            }
            notifyItemChanged(selectedPosition)
        }
    }

    class Callback : DiffUtil.ItemCallback<TransactionType>() {
        override fun areItemsTheSame(oldItem: TransactionType, newItem: TransactionType): Boolean {
            return oldItem.type == newItem.type
        }

        override fun areContentsTheSame(oldItem: TransactionType, newItem: TransactionType): Boolean {
            return oldItem == newItem
        }
    }

    interface OnClickListener {
        fun onSelectTransactionType(type: TransactionType)
    }
}