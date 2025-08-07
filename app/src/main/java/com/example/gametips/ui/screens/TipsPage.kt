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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.gametips.ui.data.models.Tips


@Composable
fun TipsPage(tipsViewModel: TipsViewModel = viewModel()  , tippers: String) {
    val tip by tipsViewModel.tip.collectAsState()

    LaunchedEffect(Unit) {
        tipsViewModel.getTips(tippers) // Fetch data when composable is shown
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(tip){item ->
           TipCard(item)
        }
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



