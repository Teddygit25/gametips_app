package com.example.gametips.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.gametips.ui.data.models.Coach
import com.example.gametips.ui.theme.Purple

@Composable
fun PaymentPage(coachName:String ,  gameName: String , navController:NavHostController) {
    var phoneNumber by remember { mutableStateOf("") }
    var isProcessing by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }


    // Runs when isProcessing becomes true
    LaunchedEffect(isProcessing) {
        if (isProcessing) {
            kotlinx.coroutines.delay(2000) // simulate payment delay
            navController.popBackStack()
            isProcessing = false
            isSuccess = true
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Box(){
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier

                        .align(Alignment.TopStart)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Back"
                    )
                }
            }
            // Title
            Text(
                text = "Pay via Mpesa",
                style = MaterialTheme.typography.headlineSmall ,
                textAlign = TextAlign.Center ,
                modifier = Modifier.fillMaxWidth()
            )
        }
        HorizontalDivider(color = Color.White.copy(alpha = 0.5f), thickness = 1.dp , modifier = Modifier.fillMaxWidth())

                // Coach info
        Text(text = "Coach: $coachName")
        Text(text = "Game: $gameName")

        // Phone number input
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Mpesa Phone Number") },
            placeholder = { Text("e.g. 07XXXXXXXX") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Text(text = "price : 10$/hr")


//        price
//        Row {
//            Text(text = "Price :")
//            Card(modifier = Modifier.padding(3.dp)
//                , colors = CardDefaults.cardColors(containerColor = Color.Blue)) {
//                Text(text = " $price")
//
//            }
//        }


        when {
            isProcessing -> {
                CircularProgressIndicator()
            }
            isSuccess -> {
                Text(
                    text = "✅ Payment Successful!",
                    color = Color.Green,
                    style = MaterialTheme.typography.titleMedium
                )

            }
            else -> {
                Button(
                    onClick = {
                        // Validate phone number
                        if (!phoneNumber.matches(Regex("^(?:07|01)\\d{8}$"))) {
                            errorMessage = "Please enter a valid Mpesa number (e.g. 0712345678)"
                        } else {
                            errorMessage = ""
                            isProcessing = true


                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Proceed to Pay")
                }
            }
        }
    }
}
