package com.qltc.finace.view.main.wallet

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.qltc.finace.R
import com.qltc.finace.base.BaseFragment
import com.qltc.finace.data.entity.Loan
import com.qltc.finace.databinding.FragmentWalletListBinding
import com.qltc.finace.view.adapter.AdapterLoan
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentWallet : BaseFragment<FragmentWalletListBinding, WalletViewModel>(),
    WalletListener,
    AdapterLoan.OnClickListener {

    override val layoutID: Int = R.layout.fragment_wallet_list
    override val viewModel: WalletViewModel by viewModels()

    private val loanAdapter by lazy { AdapterLoan(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeData()
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshData()
    }

    private fun setupViews() {
        viewBinding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@FragmentWallet.viewModel

            // Setup RecyclerView
            rvLoans.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = loanAdapter
                setHasFixedSize(true)
            }

            // Setup FAB
            fabAddLoan.setOnClickListener {
                onClickAddLoan()
            }
        }
    }

    private fun observeData() {
        viewModel.loanList.observe(viewLifecycleOwner) { loans ->
            Log.d("FragmentWallet", "Loan list size: ${loans.size}")
            loanAdapter.submitList(loans)

            // Show/hide empty view
            if (loans.isEmpty()) {
                viewBinding.rvLoans.visibility = View.GONE
                viewBinding.layoutEmpty.visibility = View.VISIBLE
            } else {
                viewBinding.rvLoans.visibility = View.VISIBLE
                viewBinding.layoutEmpty.visibility = View.GONE
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // Handle loading state if needed
        }
    }

    override fun onClickAddLoan() {
        Log.d("FragmentWallet", "Add loan clicked")
        try {
            findNavController().navigate(
                R.id.action_frag_wallet_to_add_transaction,
                Bundle().apply {
                    putString("loan_id", "") // Empty = thêm mới
                }
            )
        } catch (e: Exception) {
            Log.e("FragmentWallet", "Navigation error to add transaction", e)
            Toast.makeText(requireContext(), "Lỗi: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClickLoanItem(loan: Loan) {
        Log.d("FragmentWallet", "Loan clicked: ${loan.title}, ID: ${loan.idLoan}")

        if (loan.idLoan.isNullOrEmpty()) {
            Toast.makeText(requireContext(), "Lỗi: ID khoản vay không hợp lệ", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            findNavController().navigate(
                R.id.action_frag_wallet_to_loan_detail,
                Bundle().apply {
                    putString("loan_id", loan.idLoan)
                    putString("loan_title", loan.title ?: "Chi tiết khoản vay")
                }
            )
        } catch (e: Exception) {
            Log.e("FragmentWallet", "Navigation error to loan detail", e)
            Toast.makeText(requireContext(), "Không thể mở chi tiết: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}