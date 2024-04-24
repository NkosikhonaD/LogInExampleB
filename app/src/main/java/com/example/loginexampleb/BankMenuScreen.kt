package com.example.loginexampleb

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.loginexampleb.BankItemViewModel.BankItemViewModel
import com.example.loginexampleb.model.BankItem


/**
 * This Kotlin file is a bank menu composable.
 */

@Composable
fun BankMainScreen(bankViewModel: BankItemViewModel= viewModel(),navController: NavController)
{
    val bankItemsState by bankViewModel.bankItemList.collectAsState()

    BankMenuLayOut(bankViewModel,navController=navController)

}
@Composable
fun BankMenuLayOut(bankItemViewModel: BankItemViewModel= viewModel(), modifier : Modifier=Modifier,navController: NavController)
{
    val bankingItemsState by bankItemViewModel.bankItemList.collectAsState()
    Column(modifier= modifier
        .padding(5.dp)
        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = R.drawable.captainslogo), contentDescription ="Bank logo",modifier = modifier.size(200.dp) )
        Spacer(modifier = Modifier.height(60.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            itemsIndexed(bankingItemsState){
                    index, item -> CreateBankItemCard(bankingItems = bankingItemsState , itemIndex = index, navController = navController)
            }

        }
        Spacer(modifier = modifier.height(40.dp))

       Row (horizontalArrangement = Arrangement.End,modifier = modifier.fillMaxWidth().padding(16.dp)) {

           FloatingActionButton(
               shape = CircleShape,
               containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
               contentColor = MaterialTheme.colorScheme.inversePrimary,
               onClick = {
                   val image = R.drawable.cancel_card_24
                   val name = "Cancel card"
                   bankItemViewModel.addBankItem(BankItem(image=image,name=name))

               })
           {

               Icon(Icons.Filled.Add,"add item")
               //Text(text = "AddItem")

           }
       }




    }

}
@Composable
fun CreateBankItemCard(modifier: Modifier= Modifier, bankingItems: List<BankItem>, itemIndex:Int,navController: NavController)
{
    //val bankItems = rememberSaveable{
    //bankViewModel.getMyList()
    //}
    val bankItemName =bankingItems[itemIndex!!].name
    val bankItemImage = bankingItems[itemIndex!!].image
    val context = LocalContext.current
    Card(modifier = modifier
        .width(50.dp)
        .padding(10.dp)
        .clickable {
            if (bankItemName.equals("Transfare")) {
                navController.navigate("TransfareScreen")
            }
        },
        shape = CardDefaults.elevatedShape
    )
    {
        Column(modifier= modifier
            .fillMaxSize(1f)
            .padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = bankItemImage), contentDescription ="Icon for $bankItemName")
            Text(text =bankItemName, fontSize = 20.sp, fontWeight = FontWeight.Bold)

        }
    }

}

@Preview(showBackground = true)
@Composable
fun BankMainScreenPreview() {

    BankMainScreen(navController = NavController(LocalContext.current))

}

