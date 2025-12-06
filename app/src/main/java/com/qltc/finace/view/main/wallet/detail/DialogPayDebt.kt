package com.qltc.finace.view.main.wallet.detail

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.qltc.finace.databinding.DialogPayDebtBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@AndroidEntryPoint
class DialogPayDebt : DialogFragment() {

    private var _binding: DialogPayDebtBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoanDetailViewModel by viewModels(
        ownerProducer = { requireParentFragment() }
    )

    private var loanId: String = ""
    private var selectedDate: String = ""
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale("vi", "VN"))
    private val numberFormat by lazy {
        NumberFormat.getNumberInstance(Locale("vi", "VN")).apply {
            maximumFractionDigits = 0
        }
    }

    companion object {
        private const val ARG_LOAN_ID = "loan_id"

        fun newInstance(loanId: String): DialogPayDebt {
            return DialogPayDebt().apply {
                arguments = Bundle().apply {
                    putString(ARG_LOAN_ID, loanId)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loanId = arguments?.getString(ARG_LOAN_ID) ?: ""

        // Set ngày hiện tại
        val calendar = Calendar.getInstance()
        selectedDate = dateFormat.format(calendar.time)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogPayDebtBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeData()
    }

    private fun setupViews() {
        binding.apply {
            // Format số tiền khi nhập
            etAmount.addTextChangedListener(object : TextWatcher {
                private var current = ""

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    if (s.toString() != current) {
                        etAmount.removeTextChangedListener(this)

                        val cleanString = s.toString().replace("[,.]".toRegex(), "")
                        if (cleanString.isNotEmpty()) {
                            try {
                                val parsed = cleanString.toLong()
                                val formatted = numberFormat.format(parsed)
                                current = formatted
                                etAmount.setText(formatted)
                                etAmount.setSelection(formatted.length)
                            } catch (e: NumberFormatException) {
                                e.printStackTrace()
                            }
                        }

                        etAmount.addTextChangedListener(this)
                    }

                    // Clear error khi user nhập
                    tilAmount.error = null
                }
            })

            // Calendar listener
            calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(year, month, dayOfMonth)
                selectedDate = dateFormat.format(calendar.time)
            }

            // Cancel button
            btnCancel.setOnClickListener {
                dismiss()
            }

            // Save button
            btnSave.setOnClickListener {
                handleSavePayment()
            }
        }
    }

    private fun observeData() {
        // Observe payment success
        viewModel.paymentSuccess.observe(viewLifecycleOwner) { success ->
            if (success) {
                Toast.makeText(requireContext(), "Trả nợ thành công!", Toast.LENGTH_SHORT).show()
                dismiss()
            } else {
                Toast.makeText(requireContext(), "Trả nợ thất bại. Vui lòng thử lại!", Toast.LENGTH_SHORT).show()
            }
        }

        // Observe loading state
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.btnSave.isEnabled = !isLoading
            binding.btnCancel.isEnabled = !isLoading
            binding.etAmount.isEnabled = !isLoading
            binding.calendarView.isEnabled = !isLoading
        }

        // Observe remaining amount để validation
        viewModel.remainingAmount.observe(viewLifecycleOwner) { remaining ->
            // Có thể hiển thị số tiền còn lại cho user biết
            // VD: binding.tvRemainingInfo.text = "Còn lại: ${numberFormat.format(remaining)}đ"
        }
    }

    private fun handleSavePayment() {
        val amountText = binding.etAmount.text.toString().trim()

        // Validate loan ID
        if (loanId.isEmpty()) {
            Toast.makeText(requireContext(), "Lỗi: Không tìm thấy thông tin khoản vay", Toast.LENGTH_SHORT).show()
            dismiss()
            return
        }

        // Validate empty amount
        if (amountText.isEmpty()) {
            binding.tilAmount.error = "Vui lòng nhập số tiền"
            return
        }

        // Parse amount (remove format)
        val amount = amountText.replace(",", "").replace(".", "").toLongOrNull()

        // Validate amount format
        if (amount == null) {
            binding.tilAmount.error = "Số tiền không hợp lệ"
            return
        }

        // Validate amount > 0
        if (amount <= 0) {
            binding.tilAmount.error = "Số tiền phải lớn hơn 0"
            return
        }

        // Validate amount không vượt quá remaining amount
        val remainingAmount = viewModel.remainingAmount.value ?: 0L
        if (amount > remainingAmount) {
            binding.tilAmount.error = "Số tiền trả vượt quá số nợ còn lại (${numberFormat.format(remainingAmount)}đ)"
            return
        }

        // Clear error
        binding.tilAmount.error = null

        // Gọi ViewModel để xử lý trả nợ
        viewModel.makePayment(
            idLoan = loanId,
            amount = amount,
            date = selectedDate,
            note = null
        )
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}