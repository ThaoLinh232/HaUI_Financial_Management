package com.qltc.finace.view.main.wallet.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.qltc.finace.base.BaseViewModel
import com.qltc.finace.data.entity.Loan
import com.qltc.finace.data.repository.local.loan.LoanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@HiltViewModel
class AddTransactionViewModel @Inject constructor(
    private val loanRepository: LoanRepository
) : BaseViewModel() {

    private val _selectedDate = MutableLiveData<String>()
    val selectedDate: LiveData<String> = _selectedDate

    private val _selectedReturnDate = MutableLiveData<String>()
    val selectedReturnDate: LiveData<String> = _selectedReturnDate

    private val _amount = MutableLiveData<String>()
    val amount: LiveData<String> = _amount

    private val _note = MutableLiveData<String>()
    val note: LiveData<String> = _note

    private val _selectedLoanType = MutableLiveData<String>()
    val selectedLoanType: LiveData<String> = _selectedLoanType

    private val _saveSuccess = MutableLiveData<Boolean>()
    val saveSuccess: LiveData<Boolean> = _saveSuccess

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    // For edit mode
    private var editingLoan: Loan? = null

    init {
        // Set default date to today
        val today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        _selectedDate.value = today
    }

    fun setDate(date: String) {
        _selectedDate.value = date
    }

    fun setReturnDate(date: String) {
        _selectedReturnDate.value = date
    }

    fun setAmount(amount: String) {
        _amount.value = amount
    }

    fun setNote(note: String) {
        _note.value = note
    }

    fun setLoanType(type: String) {
        _selectedLoanType.value = type
    }

    fun loadLoanForEdit(idLoan: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val loan = loanRepository.getLoanById(idLoan)
            withContext(Dispatchers.Main) {
                if (loan != null) {
                    editingLoan = loan
                    _selectedDate.value = loan.date
                    _selectedReturnDate.value = loan.dueDate
                    _amount.value = loan.amount?.toString() ?: ""
                    _note.value = loan.note ?: ""
                    _selectedLoanType.value = loan.loanType
                }
            }
        }
    }

    fun saveLoan(title: String) {
        // Validate
        if (title.isBlank()) {
            _errorMessage.value = "Vui lòng nhập tên khoản vay"
            return
        }

        val amountValue = _amount.value?.toLongOrNull()
        if (amountValue == null || amountValue <= 0) {
            _errorMessage.value = "Vui lòng nhập số tiền hợp lệ"
            return
        }

        if (_selectedLoanType.value.isNullOrBlank()) {
            _errorMessage.value = "Vui lòng chọn nhóm"
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _isLoading.value = true
            }

            val loan = if (editingLoan != null) {
                // Update existing loan
                editingLoan!!.copy(
                    title = title,
                    amount = amountValue,
                    date = _selectedDate.value,
                    dueDate = _selectedReturnDate.value,
                    note = _note.value,
                    loanType = _selectedLoanType.value
                )
            } else {
                // Create new loan
                Loan(
                    title = title,
                    amount = amountValue,
                    paidAmount = 0L,
                    date = _selectedDate.value,
                    dueDate = _selectedReturnDate.value,
                    note = _note.value,
                    loanType = _selectedLoanType.value,
                    status = Loan.STATUS_ONGOING
                )
            }

            val success = if (editingLoan != null) {
                loanRepository.updateLoan(loan)
            } else {
                loanRepository.insertLoan(loan)
            }

            withContext(Dispatchers.Main) {
                _isLoading.value = false
                _saveSuccess.value = success
                if (!success) {
                    _errorMessage.value = "Lưu thất bại, vui lòng thử lại"
                }
            }
        }
    }

    fun resetForm() {
        editingLoan = null
        val today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        _selectedDate.value = today
        _selectedReturnDate.value = null
        _amount.value = ""
        _note.value = ""
        _selectedLoanType.value = null
    }
}