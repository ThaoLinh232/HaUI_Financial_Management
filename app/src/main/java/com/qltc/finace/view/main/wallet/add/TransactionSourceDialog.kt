package com.qltc.finace.view.main.wallet.add

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import com.qltc.finace.data.entity.Loan
import com.qltc.finace.databinding.DialogTransactionSourceBinding

class TransactionSourceDialog(
    context: Context,
    private val loanType: String,
    private val loans: List<Loan>,
    private val onLoanSelected: (Loan) -> Unit
) : Dialog(context) {

    private lateinit var binding: DialogTransactionSourceBinding
    private val adapter = LoanSourceAdapter { loan ->
        onLoanSelected(loan)
        dismiss()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        
        binding = DialogTransactionSourceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupDialog()
        setupRecyclerView()
        filterAndDisplayLoans()
    }

    private fun setupDialog() {
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        
        binding.tvDialogTitle.text = when (loanType) {
            Loan.TYPE_BORROW -> "Chọn khoản đi vay"
            Loan.TYPE_LEND -> "Chọn khoản cho vay"
            else -> "Chọn khoản vay"
        }
        
        binding.btnCancel.setOnClickListener { dismiss() }
    }

    private fun setupRecyclerView() {
        binding.rvLoans.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@TransactionSourceDialog.adapter
        }
    }

    private fun filterAndDisplayLoans() {
        // Filter loans based on type and exclude PAID status
        val filteredLoans = loans.filter { loan ->
            loan.loanType == loanType && loan.status != Loan.STATUS_PAID
        }
        
        if (filteredLoans.isEmpty()) {
            binding.rvLoans.visibility = View.GONE
            binding.tvEmptyState.visibility = View.VISIBLE
        } else {
            binding.rvLoans.visibility = View.VISIBLE
            binding.tvEmptyState.visibility = View.GONE
            adapter.submitList(filteredLoans)
        }
    }
}
