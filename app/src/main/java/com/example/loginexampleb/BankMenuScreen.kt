package com.example.loginexampleb

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginexampleb.BankItemViewModel.BankItemViewModel
import com.example.loginexampleb.model.BankItem

@Composable
fun BankMainScreen(bankViewModel: BankItemViewModel= viewModel())
{
    val bankItemsState by bankViewModel.bankItemList.collectAsState()

    BankMenuLayOut(bankViewModel)

}
@Composable
fun BankMenuLayOut(bankItemViewModel: BankItemViewModel= viewModel(), modifier : Modifier=Modifier)
{
    val bankingItemsState by bankItemViewModel.bankItemList.collectAsState()
    Column(modifier= modifier
        .padding(5.dp)
        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = R.drawable.captainslogo), contentDescription ="Bank logo" )
        Spacer(modifier = Modifier.height(60.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            itemsIndexed(bankingItemsState){
                    index, item -> CreateBankItemCard(bankingItems = bankingItemsState , itemIndex = index)
            }

        }
        FloatingActionButton(onClick = {
            val image = R.drawable.cancel_card_24
            val name = "Cancel card"
            bankItemViewModel.addBankItem(BankItem(image=image,name=name))

        })
        {
            Text(text = "AddItem")

        }



    }

}
@Composable
fun CreateBankItemCard(modifier: Modifier= Modifier, bankingItems: List<BankItem>, itemIndex:Int)
{
    //val bankItems = rememberSaveable{
    //bankViewModel.getMyList()
    //}
    val context = LocalContext.current
    Card(modifier = modifier
        .width(50.dp)
        .padding(10.dp)
        .clickable {
            Toast
                .makeText(
                    context,
                    "Banking Menu item ${bankingItems[itemIndex].name} clicked",
                    Toast.LENGTH_SHORT
                )
                .show()
        },
        shape = CardDefaults.elevatedShape
    )
    {
        Column(modifier= modifier
            .fillMaxSize(1f)
            .padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = bankingItems[itemIndex!!].image), contentDescription ="Icon for $bankingItems[itemIndex!!].name")
            Text(text =bankingItems[itemIndex!!].name, fontSize = 20.sp, fontWeight = FontWeight.Bold)

        }
    }

}
