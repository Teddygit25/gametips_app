package com.example.gametips.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.gametips.ui.data.models.Tips


@Composable
fun TipsPage(tipsViewModel: TipsViewModel ,  tipper: String ,  navController:NavHostController ,) {
    val tip by tipsViewModel.tip.collectAsState()

    var showDialog by remember { mutableStateOf(false) }
    var tipToDelete by remember { mutableStateOf<Tips?>(null) }

    LaunchedEffect (Unit){
        tipsViewModel.getTips(tipper)
    }

    Column {
        Button(onClick = {
            navController.navigate("add Tip")
        }) {
            Text(text = "Add tip")
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(tip){item ->
                Text(text = " ${item.name}" , fontSize = 32.sp)
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Tip 1" , fontSize = 26.sp , fontWeight = FontWeight.Bold)

                Text(text = " ${item.tip1}")
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Tip 2" , fontSize = 26.sp , fontWeight = FontWeight.Bold)

                Text(text = " ${item.tip2}")
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Tip 3" , fontSize = 26.sp , fontWeight = FontWeight.Bold)

                Text(text = " ${item.tip3}")
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Universal Tip" , fontSize = 26.sp , fontWeight = FontWeight.Bold)

                Text(text = " ${item.universalTip}")
                Spacer(modifier = Modifier.height(8.dp))

                // Delete button
                Button(
                    onClick = {
                        tipToDelete = item
                        showDialog = true
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text("Delete", color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))


            }
        }
    }

    // Confirmation Dialog
    if (showDialog && tipToDelete != null) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Delete Tip") },
            text = { Text("Are you sure you want to delete '${tipToDelete!!.name}'?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        tipsViewModel.deleteTip(tipToDelete!!.id)
                        showDialog = false
                    }
                ) {
                    Text("Yes", color = Color.Red)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text("Cancel")
                }
            }
        )
    }





}

@Composable
fun TipCard(tip: Tips) {
    Card(
        modifier = Modifier
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Game: ${tip.name}", style = MaterialTheme.typography.titleMedium)
            Text("Category: ${tip.description}")
            Text("Tip1: ${tip.tip1}")
            Text("tip2: ${tip.tip2}")
            Text("Rating: ${tip.tip3}")
            Text("Rating: ${tip.universalTip}")
        }
    }
}



