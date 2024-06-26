package com.example.loginexampleb.BankItemViewModel

import androidx.lifecycle.ViewModel
import com.example.loginexampleb.R
import com.example.loginexampleb.model.BankItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BankItemViewModel(): ViewModel ()
{

    private val _bankItemList= MutableStateFlow<List<BankItem>>(addBankItemsInit())
    val bankItemList: StateFlow<List<BankItem>> get() = _bankItemList

    fun resetBankItems()
    {
        //bankItemList.clear()
        //bankItemList = addBankItemsInit()
    }
    init {
        resetBankItems()
    }

     private fun addBankItemsInit(): List<BankItem>
    {
        val bankItem1 = BankItem(name="Transfare", image = R.drawable.transact_24)
        val bankItem2 = BankItem(name="Save", image = R.drawable.savings_24)
        val bankItem3 = BankItem(name="Cards", image = R.drawable.cards_24)
        val bankItem4 = BankItem(name="Fraud", image = R.drawable.reportfraud_24)
        val bankItem5 = BankItem(name="Contact", image = R.drawable.email_24)
        val bankItem6= BankItem(name="Petrol card", image = R.drawable.petrolcard_24)
        return listOf<BankItem>(bankItem1,bankItem2,bankItem3,bankItem4,bankItem5,bankItem6)

    }

    fun addBankItem(item:BankItem)
    {
       _bankItemList.value+=item
    }



}

