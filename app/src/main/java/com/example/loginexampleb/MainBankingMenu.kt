package com.example.loginexampleb

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginexampleb.ui.theme.LogInExampleBTheme

class MainBankingMenu : ComponentActivity() {
    val TAG : String = "MainBankingMenu Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogInExampleBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    val bankItem1 = BankItem(name="Transfare", image = R.drawable.transact_24)
                    val bankItem2 = BankItem(name="Save", image = R.drawable.savings_24)
                    val bankItem3 = BankItem(name="Cards", image = R.drawable.cards_24)
                    val bankItem4 = BankItem(name="Fraud", image = R.drawable.reportfraud_24)
                    val bankItem5 = BankItem(name="Contact", image = R.drawable.email_24)
                    val bankItem6= BankItem(name="Petrol card", image = R.drawable.petrolcard_24)

                    var bankItemsList by remember {
                        mutableStateOf(listOf<BankItem>(bankItem1,bankItem2,bankItem3,bankItem4,bankItem5,bankItem6))
                    }
                    MainMenuLazyGridScreen(bankingItems = bankItemsList)
                }
            }
        }
    }
    //


}

@Composable
fun MainMenuLazyGridScreen(modifier:Modifier = Modifier, bankingItems:List<BankItem>)
{
    Column(modifier= modifier
        .padding(5.dp)
        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,) {

        Image(painter = painterResource(id = R.drawable.CaptainsLogo), contentDescription ="Bank logo" )
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            itemsIndexed(bankingItems){
                    index, item -> CreateBankItemCard(bankingItems = bankingItems , itemIndex = index )
            }

        }
    }


}
@Composable
fun CreateBankItemCard(modifier: Modifier= Modifier, bankingItems: List<BankItem>, itemIndex:Int)
{
    val context = LocalContext.current
    Card(modifier = modifier
        .width(50.dp)
        .padding(10.dp)
        .clickable {
                   Toast.makeText(context,"Banking Menu item ${bankingItems[itemIndex].name} clicked",Toast.LENGTH_SHORT).show()
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
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    LogInExampleBTheme {
        val bankItem1 = BankItem(name="Transfare", image = R.drawable.transact_24)
        val bankItem2 = BankItem(name="Save", image = R.drawable.savings_24)
        val bankItem3 = BankItem(name="Cards", image = R.drawable.cards_24)
        val bankItem4 = BankItem(name="Fraud", image = R.drawable.reportfraud_24)
        val bankItem5 = BankItem(name="Contact", image = R.drawable.email_24)
        val bankItem6= BankItem(name="Petrol card", image = R.drawable.petrolcard_24)

        var bankItemsList by remember {
            mutableStateOf(listOf<BankItem>(bankItem1,bankItem2,bankItem3,bankItem4,bankItem5,bankItem6))
        }
        MainMenuLazyGridScreen(bankingItems = bankItemsList)
    }
}