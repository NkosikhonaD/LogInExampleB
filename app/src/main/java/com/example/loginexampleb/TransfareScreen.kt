import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginexampleb.BankItemViewModel.TransactionViewModel
import com.example.loginexampleb.R

@Composable
fun TransfareScreen(transactionViewModel: TransactionViewModel = viewModel(), modifier: Modifier= Modifier)
{
    var transfareAmount by remember {
        mutableStateOf("00")
    }
    var bankAccount = transactionViewModel.bankAccount.collectAsState()
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp), 
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(id = R.drawable.captainslogo),
            contentDescription = "logo",
            modifier = modifier
                .size(200.dp)
                .clip(
                    shape = RoundedCornerShape(6.dp)
                )
        )
        Text(
            text = "Current balance = ${bankAccount.value.balance}",
            fontSize = 18.sp,
            modifier = modifier.fillMaxWidth(1f)
        )
        OutlinedTextField(
            modifier = modifier.fillMaxWidth(1f),
            value = transfareAmount,
            onValueChange = { transfareAmount = it },
            label = { Text(text = "Transfare Amount") }
        )


        Button(modifier = modifier.fillMaxWidth(1f),
            onClick = {
                transactionViewModel.transfare(transfareAmount.toDouble())
            })
        {
            Text(text = "Transfare")
        }

    }


}
@Preview(showBackground = true)
@Composable
fun TransfareScreenPreview() {

        TransfareScreen()

}
