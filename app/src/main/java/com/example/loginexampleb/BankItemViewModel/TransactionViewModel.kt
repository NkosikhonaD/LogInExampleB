package com.example.loginexampleb.BankItemViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.loginexampleb.model.BankAccount
import kotlinx.coroutines.flow.update

class TransactionViewModel: ViewModel()
{
    private val _bankAccount= MutableStateFlow<BankAccount>(initialBankAccount())

    val bankAccount: StateFlow<BankAccount> get() =_bankAccount


    fun  initialBankAccount() : BankAccount
    {
        val initialBankAccount = BankAccount(balance = 500.0, transactions = listOf<String>("Withdraw R00"))

        return  initialBankAccount
    }
    fun transfare(transfareAmount: Double)
    {

        if (transfareAmount<=_bankAccount.value.balance)
        {
            val newBalance =_bankAccount.value.balance - transfareAmount
            _bankAccount.update { bankAccount -> bankAccount.copy(balance = newBalance) }
        }

    }
}