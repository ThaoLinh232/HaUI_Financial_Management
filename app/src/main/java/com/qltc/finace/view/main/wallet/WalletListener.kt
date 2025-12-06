package com.qltc.finace.view.main.wallet

import com.qltc.finace.data.entity.Loan

interface WalletListener {
    fun onClickAddLoan()
    fun onClickLoanItem(loan: Loan)
}