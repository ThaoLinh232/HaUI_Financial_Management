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

    // ===== LOAN SOURCE SELECTION (MVVM Pattern) =====
    private val _allLoans = MutableLiveData<List<Loan>>(emptyList())
    val allLoans: LiveData<List<Loan>> = _allLoans
    
    private val _requireSourceLoanSelection = MutableLiveData<String?>()
    val requireSourceLoanSelection: LiveData<String?> = _requireSourceLoanSelection
    
    private val _selectedSourceLoan = MutableLiveData<Loan?>()
    val selectedSourceLoan: LiveData<Loan?> = _selectedSourceLoan
    
    private val _paymentAmount = MutableLiveData<Long>()
    val paymentAmount: LiveData<Long> = _paymentAmount

    // For edit mode
    private var editingLoan: Loan? = null

    init {
        // Set default date to today
        val today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        _selectedDate.value = today
        
        // Load all loans for source selection
        loadAllLoans()
    }
    
    // ===== MVVM: Business Logic Methods =====
    
    // Load all loans from repository
    private fun loadAllLoans() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val loans = loanRepository.getAllLoans()
                withContext(Dispatchers.Main) {
                    _allLoans.value = loans
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _errorMessage.value = "Không thể tải danh sách khoản vay: ${e.message}"
                }
            }
        }
    }
    
    // Check if selected loan type requires source selection
    fun onLoanTypeSelected(loanType: String) {
        _selectedLoanType.value = loanType
        
        // Reset source loan when changing type
        _selectedSourceLoan.value = null
        
        when (loanType) {
            Loan.TYPE_PAY_DEBT -> {
                // Trả nợ -> chọn khoản ĐI VAY
                _requireSourceLoanSelection.value = Loan.TYPE_BORROW
            }
            Loan.TYPE_DEBT_COLLECTION -> {
                // Thu nợ -> chọn khoản CHO VAY
                _requireSourceLoanSelection.value = Loan.TYPE_LEND
            }
            else -> {
                _requireSourceLoanSelection.value = null
            }
        }
    }
    
    // User selected a source loan from dialog
    fun onSourceLoanSelected(loan: Loan) {
        _selectedSourceLoan.value = loan
        _requireSourceLoanSelection.value = null // Dismiss dialog
    }
    
    // Clear source loan selection
    private fun clearSourceLoanSelection() {
        _selectedSourceLoan.value = null
        _requireSourceLoanSelection.value = null
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
        val loanType = _selectedLoanType.value
        
        // Validate loan type
        if (loanType.isNullOrBlank()) {
            _errorMessage.value = "Vui lòng chọn nhóm"
            return
        }
        
        // Validate source loan for PAY_DEBT and DEBT_COLLECTION
        if ((loanType == Loan.TYPE_PAY_DEBT || loanType == Loan.TYPE_DEBT_COLLECTION) 
            && _selectedSourceLoan.value == null) {
            _errorMessage.value = "Vui lòng chọn khoản vay nguồn"
            return
        }
        
        // Validate title
        if (title.isBlank()) {
            _errorMessage.value = "Vui lòng nhập tên khoản vay"
            return
        }

        val amountValue = _amount.value?.toLongOrNull()
        if (amountValue == null || amountValue <= 0) {
            _errorMessage.value = "Vui lòng nhập số tiền hợp lệ"
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _isLoading.value = true
            }

            try {
                val success = when (loanType) {
                    Loan.TYPE_PAY_DEBT, Loan.TYPE_DEBT_COLLECTION -> {
                        // Make payment to existing loan
                        makePaymentToSourceLoan(amountValue)
                    }
                    else -> {
                        // Create or update loan (BORROW, LEND)
                        saveNormalLoan(title, amountValue)
                    }
                }

                withContext(Dispatchers.Main) {
                    _isLoading.value = false
                    _saveSuccess.value = success
                    if (!success) {
                        _errorMessage.value = "Lưu thất bại, vui lòng thử lại"
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _isLoading.value = false
                    _errorMessage.value = "Lỗi: ${e.message}"
                }
            }
        }
    }
    
    // MVVM: Private helper - Save normal loan (BORROW, LEND)
    private suspend fun saveNormalLoan(title: String, amountValue: Long): Boolean {
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

        return if (editingLoan != null) {
            loanRepository.updateLoan(loan)
        } else {
            loanRepository.insertLoan(loan)
        }
    }
    
    // MVVM: Private helper - Make payment to source loan
    private suspend fun makePaymentToSourceLoan(amountValue: Long): Boolean {
        val sourceLoan = _selectedSourceLoan.value ?: return false
        val sourceLoanId = sourceLoan.idLoan ?: return false
        
        return loanRepository.makePayment(
            idLoan = sourceLoanId,
            amount = amountValue,
            date = _selectedDate.value ?: "",
            note = _note.value
        )
    }

    fun resetForm() {
        editingLoan = null
        val today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        _selectedDate.value = today
        _selectedReturnDate.value = null
        _amount.value = ""
        _note.value = ""
        _selectedLoanType.value = null
        clearSourceLoanSelection()
    }
}