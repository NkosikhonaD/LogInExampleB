package com.example.loginexampleb.BankItemViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.loginexampleb.R
import com.example.loginexampleb.model.BankItem

class BankItemViewModel ()
{
    var bankItemList by mutableStateOf(listOf<BankItem>())
    fun addBankItem(name:String,image:Int)
    {
        var bankItem = BankItem(name=name,image= image)
        bankItemList+(bankItem)
    }
    fun getBankItemList():List<BankItem>
    {
        return bankItemList
    }

}