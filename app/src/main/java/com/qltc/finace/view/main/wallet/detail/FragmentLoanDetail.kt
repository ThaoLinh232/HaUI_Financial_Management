package com.qltc.finace.view.main.wallet.detail

import android.os.Bundle
import android.util.Log
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

        // Lấy loan_id từ arguments
        loanId = arguments?.getString("loan_id")
        Log.d("FragmentLoanDetail", "Received loan_id: $loanId")
        Log.d("FragmentLoanDetail", "All arguments: ${arguments?.keySet()?.joinToString()}")

        if (loanId.isNullOrEmpty()) {
            Toast.makeText(requireContext(), "Lỗi: Không tìm thấy thông tin khoản vay", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
            return
        }

        setupViews()
        observeData()
        Log.d("FragmentLoanDetail", "Loading loan detail for ID: $loanId")
        viewModel.loadLoanDetail(loanId!!)
    }

    private fun setupViews() {
        viewBinding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@FragmentLoanDetail.viewModel
            listener = this@FragmentLoanDetail

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
            Log.d("FragmentLoanDetail", "Loan data received: ${loan?.idLoan}, title: ${loan?.title}")
            loan?.let {
                Log.d("FragmentLoanDetail", "Updating UI with loan data: amount=${loan.amount}, paid=${loan.paidAmount}")
                viewBinding.apply {
                    // Hiển thị tiêu đề
                    tvLoanTitle.text = loan.title ?: "Chi tiết khoản vay"
                    
                    // Thời gian tạo
                    tvTime.text = loan.date ?: "N/A"
                    
                    // Thời gian trả dự kiến
                    tvDueDate.text = loan.dueDate ?: "Chưa xác định"
                    
                    // Tổng số tiền
                    tvTotal.text = "${numberFormat.format(loan.amount ?: 0L)} đ"
                    
                    // Tiền đã trả
                    tvInterest.text = "${numberFormat.format(loan.paidAmount ?: 0L)} đ"

                    // Số tiền còn lại
                    val remaining = loan.getRemainingAmount()
                    tvRemaining.text = "${numberFormat.format(remaining)} đ"

                    // Kiểm tra trạng thái để enable/disable nút trả nợ
                    btnPay.isEnabled = loan.status != com.qltc.finace.data.entity.Loan.STATUS_PAID
                }
                Log.d("FragmentLoanDetail", "UI updated successfully")
            } ?: run {
                Log.e("FragmentLoanDetail", "Loan data is NULL")
            }
        }

        viewModel.paymentHistory.observe(viewLifecycleOwner) { payments ->
            paymentAdapter.submitList(payments)
            viewBinding.rvTransactions.visibility = if (payments.isEmpty()) View.GONE else View.VISIBLE
        }

        viewModel.paymentSuccess.observe(viewLifecycleOwner) { success ->
            if (success) {
                Toast.makeText(requireContext(), "Trả nợ thành công", Toast.LENGTH_SHORT).show()
                // Refresh data sau khi trả nợ thành công
                loanId?.let { viewModel.loadLoanDetail(it) }
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