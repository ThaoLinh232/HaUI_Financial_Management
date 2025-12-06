package com.qltc.finace.view.main.wallet

import android.util.Log
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

@HiltViewModel
class WalletViewModel @Inject constructor(
    private val loanRepository: LoanRepository
) : BaseViewModel() {

    companion object {
        private const val TAG = "WalletViewModel"
    }

    private val _loanList = MutableLiveData<List<Loan>>(emptyList())
    val loanList: LiveData<List<Loan>> = _loanList

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _totalBorrowed = MutableLiveData<Long>(0L) // Tổng đi vay
    val totalBorrowed: LiveData<Long> = _totalBorrowed

    private val _totalLent = MutableLiveData<Long>(0L) // Tổng cho vay
    val totalLent: LiveData<Long> = _totalLent

    init {
        Log.d(TAG, "===== WALLET VIEWMODEL CREATED =====")
        loadAllLoans()
    }

    fun loadAllLoans() {
        Log.d(TAG, "loadAllLoans() called")
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _isLoading.value = true
                Log.d(TAG, "Loading started...")
            }

            try {
                val loans = loanRepository.getAllLoans()
                Log.d(TAG, "Loans loaded from repository: ${loans.size} items")

                // Sắp xếp: ONGOING lên trên, PAID xuống dưới
                val sortedLoans = loans.sortedWith(compareBy<Loan> { 
                    // STATUS_PAID = 1, STATUS_ONGOING = 0 (ONGOING lên trước)
                    if (it.status == Loan.STATUS_PAID) 1 else 0
                }.thenByDescending { 
                    // Trong cùng status, sắp xếp theo ngày tạo mới nhất
                    it.date ?: ""
                })

                sortedLoans.forEachIndexed { index, loan ->
                    Log.d(TAG, "Loan $index: ${loan.title}, Status: ${loan.status}, ID: ${loan.idLoan}")
                }

                withContext(Dispatchers.Main) {
                    _loanList.value = sortedLoans
                    calculateTotals(sortedLoans)
                    _isLoading.value = false
                    Log.d(TAG, "LiveData updated successfully with ${sortedLoans.size} loans")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error loading loans", e)
                withContext(Dispatchers.Main) {
                    _isLoading.value = false
                }
            }
        }
    }

    private fun calculateTotals(loans: List<Loan>) {
        var borrowed = 0L
        var lent = 0L

        loans.forEach { loan ->
            val remaining = loan.getRemainingAmount()
            when (loan.loanType) {
                Loan.TYPE_BORROW -> borrowed += remaining
                Loan.TYPE_LEND -> lent += remaining
            }
        }

        _totalBorrowed.value = borrowed
        _totalLent.value = lent

        Log.d(TAG, "Totals calculated - Borrowed: $borrowed, Lent: $lent")
    }

    fun deleteLoan(loan: Loan) {
        Log.d(TAG, "deleteLoan() called for: ${loan.title}")
        viewModelScope.launch(Dispatchers.IO) {
            val success = loanRepository.deleteLoan(loan)
            Log.d(TAG, "Delete result: $success")
            if (success) {
                withContext(Dispatchers.Main) {
                    loadAllLoans() // Refresh list
                }
            }
        }
    }

    fun refreshData() {
        Log.d(TAG, "refreshData() called")
        loadAllLoans()
    }
}