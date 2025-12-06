package com.qltc.finace.view.main.wallet.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.qltc.finace.base.BaseViewModel
import com.qltc.finace.data.entity.Loan
import com.qltc.finace.data.entity.LoanPayment
import com.qltc.finace.data.repository.local.loan.LoanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoanDetailViewModel @Inject constructor(
    private val loanRepository: LoanRepository
) : BaseViewModel() {

    private val _loan = MutableLiveData<Loan?>()
    val loan: LiveData<Loan?> = _loan

    private val _paymentHistory = MutableLiveData<List<LoanPayment>>(emptyList())
    val paymentHistory: LiveData<List<LoanPayment>> = _paymentHistory

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _remainingAmount = MutableLiveData<Long>(0L)
    val remainingAmount: LiveData<Long> = _remainingAmount

    private val _paymentSuccess = MutableLiveData<Boolean>()
    val paymentSuccess: LiveData<Boolean> = _paymentSuccess

    fun loadLoanDetail(idLoan: String) {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _isLoading.value = true
            }

            val loanData = loanRepository.getLoanById(idLoan)
            val payments = if (loanData != null) {
                loanRepository.getAllPaymentsByLoan(idLoan)
            } else {
                emptyList()
            }

            withContext(Dispatchers.Main) {
                _loan.value = loanData
                _paymentHistory.value = payments.sortedByDescending { it.date }
                _remainingAmount.value = loanData?.getRemainingAmount() ?: 0L
                _isLoading.value = false
            }
        }
    }

    fun makePayment(idLoan: String, amount: Long, date: String, note: String? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _isLoading.value = true
            }

            val success = loanRepository.makePayment(idLoan, amount, date, note)

            withContext(Dispatchers.Main) {
                _paymentSuccess.value = success
                _isLoading.value = false

                if (success) {
                    // Reload loan detail after payment
                    loadLoanDetail(idLoan)
                }
            }
        }
    }

    fun refreshData() {
        _loan.value?.idLoan?.let { idLoan ->
            loadLoanDetail(idLoan)
        }
    }
}