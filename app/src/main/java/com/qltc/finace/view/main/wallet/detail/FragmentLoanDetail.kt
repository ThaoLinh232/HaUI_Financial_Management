package com.qltc.finace.view.main.wallet.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.qltc.finace.R
import com.qltc.finace.base.BaseFragment
import com.qltc.finace.databinding.FragmentWalletDetailBinding
import com.qltc.finace.view.adapter.AdapterLoanPayment
import dagger.hilt.android.AndroidEntryPoint
import java.text.NumberFormat
import java.util.Locale
import com.qltc.finace.view.main.wallet.detail.DialogPayDebt
@AndroidEntryPoint
class FragmentLoanDetail : BaseFragment<FragmentWalletDetailBinding, LoanDetailViewModel>(),
    LoanDetailListener {

    override val layoutID: Int = R.layout.fragment_wallet_detail
    override val viewModel: LoanDetailViewModel by viewModels()

    private val paymentAdapter by lazy { AdapterLoanPayment() }
    private var loanId: String? = null

    private val numberFormat by lazy {
        NumberFormat.getNumberInstance(Locale("vi", "VN")).apply {
            maximumFractionDigits = 0
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // SỬA: Lấy arguments theo cách truyền thống
        loanId = arguments?.getString("loan_id")
        val loanTitle = arguments?.getString("loan_title")

        if (loanId.isNullOrEmpty()) {
            Toast.makeText(requireContext(), "Lỗi: Không tìm thấy thông tin khoản vay", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
            return
        }

        setupViews(loanTitle)
        observeData()
        viewModel.loadLoanDetail(loanId!!)
    }

    private fun setupViews(loanTitle: String?) {
        viewBinding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@FragmentLoanDetail.viewModel
            listener = this@FragmentLoanDetail

            tvLoanTitle.text = loanTitle ?: "Chi tiết khoản vay"

            rvTransactions.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = paymentAdapter
            }

            btnBack.setOnClickListener { onClickBack() }
            btnPay.setOnClickListener { onClickPayDebt() }
        }
    }

    private fun observeData() {
        viewModel.loan.observe(viewLifecycleOwner) { loan ->
            loan?.let {
                viewBinding.apply {
                    tvTime.text = loan.date ?: "N/A"
                    tvDueDate.text = loan.dueDate ?: "Chưa xác định"
                    tvTotal.text = "${numberFormat.format(loan.amount ?: 0L)} đ"
                    tvInterest.text = "${numberFormat.format(loan.paidAmount ?: 0L)}đ"

                    val remaining = loan.getRemainingAmount()
                    tvRemaining.text = "${numberFormat.format(remaining)}đ"

                    btnPay.isEnabled = loan.status != com.qltc.finace.data.entity.Loan.STATUS_PAID
                }
            }
        }

        viewModel.paymentHistory.observe(viewLifecycleOwner) { payments ->
            paymentAdapter.submitList(payments)
            viewBinding.rvTransactions.visibility = if (payments.isEmpty()) View.GONE else View.VISIBLE
        }

        viewModel.paymentSuccess.observe(viewLifecycleOwner) { success ->
            if (success) {
                Toast.makeText(requireContext(), "Trả nợ thành công", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Trả nợ thất bại", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClickBack() {
        findNavController().popBackStack()
    }

    override fun onClickPayDebt() {
        if (loanId != null) {
            val dialog = DialogPayDebt.newInstance(loanId!!)
            dialog.show(childFragmentManager, "DialogPayDebt")
        } else {
            Toast.makeText(requireContext(), "Lỗi: Không tìm thấy ID khoản vay", Toast.LENGTH_SHORT).show()
        }
    }
}