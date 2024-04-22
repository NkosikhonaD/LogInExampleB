package com.example.loginexampleb.model

data class BankAccount(val balance: Double,val transactions:List<String>)
{
    var balance_current: Double = balance
        get()
        {
            return field
        }
        set(value) {
            field = value
        }
    var transactions_current: List<String> =transactions
        get(){
            return field

        }
        set(value)
        {
            field = value
        }
}
