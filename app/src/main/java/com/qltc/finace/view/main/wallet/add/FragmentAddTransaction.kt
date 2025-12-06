package com.qltc.finace.view.main.wallet.add

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.qltc.finace.R
import com.qltc.finace.base.BaseFragment
import com.qltc.finace.data.entity.Loan
import com.qltc.finace.databinding.AddTransactionBinding
import com.qltc.finace.view.adapter.AdapterTransactionType
import com.qltc.finace.view.adapter.TransactionType
import com.qltc.finace.view.main.wallet.add.TransactionSourceDialog
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@AndroidEntryPoint
class FragmentAddTransaction : BaseFragment<AddTransactionBinding, AddTransactionViewModel>(),
    AddTransactionListener,
    AdapterTransactionType.OnClickListener {

    override val layoutID: Int = R.layout.add_transaction
    override val viewModel: AddTransactionViewModel by viewModels()

    private val transactionTypeAdapter by lazy { AdapterTransactionType(this) }

    private val transactionTypes = listOf(
        TransactionType(Loan.TYPE_DEBT_COLLECTION, "Thu nợ", "$"),
        TransactionType(Loan.TYPE_BORROW, "Đi vay", "$"),
        TransactionType(Loan.TYPE_LEND, "Cho vay", "$"),
        TransactionType(Loan.TYPE_PAY_DEBT, "Trả nợ", "$")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeData()

        // SỬA: Lấy arguments theo cách truyền thống
        val loanId = arguments?.getString("loan_id")
        if (!loanId.isNullOrEmpty()) {
            viewModel.loadLoanForEdit(loanId)
        }
    }

    private fun setupViews() {
        viewBinding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@FragmentAddTransaction.viewModel
            listener = this@FragmentAddTransaction

            rvTransactionTypes.apply {
                layoutManager = GridLayoutManager(requireContext(), 4)
                adapter = transactionTypeAdapter
            }
            transactionTypeAdapter.submitList(transactionTypes)

            etDate.setOnClickListener { showDatePicker(true) }
            tilDate.setEndIconOnClickListener { showDatePicker(true) }

            etReturnDate.setOnClickListener { showDatePicker(false) }
            tilReturnDate.setEndIconOnClickListener { showDatePicker(false) }

            btnSave.setOnClickListener { onClickSave() }
            btnSaveToolbar.setOnClickListener { onClickSave() }
            btnBack.setOnClickListener { onClickBack() }
        }
    }

    private fun observeData() {
        viewModel.selectedDate.observe(viewLifecycleOwner) { date ->
            viewBinding.etDate.setText(date)
        }

        viewModel.selectedReturnDate.observe(viewLifecycleOwner) { date ->
            viewBinding.etReturnDate.setText(date)
        }

        viewModel.selectedLoanType.observe(viewLifecycleOwner) { type ->
            type?.let {
                transactionTypeAdapter.setSelectedType(it)
            }
        }

        viewModel.saveSuccess.observe(viewLifecycleOwner) { success ->
            if (success) {
                Toast.makeText(requireContext(), "Lưu thành công", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
        
        // MVVM: Observer for source loan selection requirement
        viewModel.requireSourceLoanSelection.observe(viewLifecycleOwner) { loanType ->
            if (loanType != null) {
                showTransactionSourceDialog(loanType)
            }
        }
        
        // MVVM: Observer for selected source loan
        viewModel.selectedSourceLoan.observe(viewLifecycleOwner) { loan ->
            loan?.let {
                Toast.makeText(
                    requireContext(), 
                    "Đã chọn: ${it.title}", 
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    
    // MVVM: View only displays dialog, logic is in ViewModel
    private fun showTransactionSourceDialog(loanType: String) {
        val loans = viewModel.allLoans.value ?: emptyList()
        
        TransactionSourceDialog(
            context = requireContext(),
            loanType = loanType,
            loans = loans,
            onLoanSelected = { loan ->
                // MVVM: Notify ViewModel about user action
                viewModel.onSourceLoanSelected(loan)
            }
        ).show()
    }

    private fun showDatePicker(isStartDate: Boolean) {
        val calendar = Calendar.getInstance()

        val currentDate = if (isStartDate) {
            viewModel.selectedDate.value
        } else {
            viewModel.selectedReturnDate.value
        }

        currentDate?.let { dateStr ->
            try {
                val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                val date = LocalDate.parse(dateStr, formatter)
                calendar.set(date.year, date.monthValue - 1, date.dayOfMonth)
            } catch (e: Exception) {
                // Use current date if parsing fails
            }
        }

        DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                val selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
                val formattedDate = selectedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))

                if (isStartDate) {
                    viewModel.setDate(formattedDate)
                } else {
                    viewModel.setReturnDate(formattedDate)
                }
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    override fun onClickBack() {
        findNavController().popBackStack()
    }

    override fun onClickSave() {
        val amount = viewBinding.etAmount.text.toString()
        val note = viewBinding.etNote.text.toString()

        val loanType = viewModel.selectedLoanType.value
        val title = when (loanType) {
            Loan.TYPE_BORROW -> "Khoản đi vay"
            Loan.TYPE_LEND -> "Khoản cho vay"
            Loan.TYPE_DEBT_COLLECTION -> "Thu nợ"
            Loan.TYPE_PAY_DEBT -> "Trả nợ"
            else -> "Khoản vay"
        }

        viewModel.setAmount(amount)
        viewModel.setNote(note)
        viewModel.saveLoan(title)
    }

    override fun onSelectTransactionType(type: TransactionType) {
        // MVVM: Delegate business logic to ViewModel
        viewModel.onLoanTypeSelected(type.type)
    }
}