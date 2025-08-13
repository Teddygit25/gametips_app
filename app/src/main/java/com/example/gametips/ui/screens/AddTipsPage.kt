package com.example.gametips.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gametips.ui.data.models.Tips

@Composable
fun AddTipScreen(viewModel: TipsViewModel , navController:NavHostController) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var tip1 by remember { mutableStateOf("") }
    var tip2 by remember { mutableStateOf("") }
    var tip3 by remember { mutableStateOf("") }
    var universalTip by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") }
        )

        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Content") }
        )
        OutlinedTextField(
                    value = tip1,
                    onValueChange = { tip1 = it },
                    label = { Text("Tip 1") }
                )
        OutlinedTextField(
                    value = tip2,
                    onValueChange = { tip2 = it },
                    label = { Text("Tip 2") }
                )
        OutlinedTextField(
                    value = tip3,
                    onValueChange = { tip3 = it },
                    label = { Text("Tip 3") }
                )
        OutlinedTextField(
                    value = universalTip,
                    onValueChange = { universalTip = it },
                    label = { Text("Universal Tip") }
                )

        Button(
            onClick = {
                val newTip = Tips(
                    name = title,
                    description = content ,
                    tip1 = tip1 , tip2 = tip2 ,
                    tip3 = tip3 ,
                    universalTip = universalTip
                )
                viewModel.addTips(newTip)
                navController.popBackStack()
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Add Tip")
        }
    }
}
