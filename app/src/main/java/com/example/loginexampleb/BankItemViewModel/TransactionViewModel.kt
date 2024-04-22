package com.example.loginexampleb.BankItemViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.loginexampleb.model.BankAccount

class TransactionViewModel: ViewModel()
{
    private val _bankAccount: MutableStateFlow<BankAccount> = initialBankAccount()

    val bankAccount: StateFlow<BankAccount> get() =_bankAccount


    fun  initialBankAccount() : MutableStateFlow<BankAccount>
    {
        val initialBankAccount = BankAccount(balance = 500.0, transactions = listOf<String>("Withdraw R00"))

        return  MutableStateFlow<BankAccount> (initialBankAccount)
    }
}