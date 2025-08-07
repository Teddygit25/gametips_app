package com.example.gametips.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gametips.R
import com.example.gametips.ui.components.FontFamilyLobster
import com.example.gametips.ui.components.GameCard
import com.example.gametips.ui.components.Screen
import com.example.gametips.ui.data.models.Game
import com.example.gametips.ui.data.models.GameCategoryNav


@Composable
fun GameListPage(category: String , navController:NavHostController ) {
    val games:List<Game> = when (category.lowercase()) {
        "fighting" -> listOf(
            Game("Mortal Kombat", R.drawable.scorpion),
            Game("Street Fighter", R.drawable.street_fighter),
            Game("Tekken", R.drawable.tekken),
            Game("Injustice 2", R.drawable.injustice)
        )
        "racing" -> listOf(
            Game("Need for Speed", R.drawable.nfs),
            Game("Blur", R.drawable.blur),
            Game("Asphalt 9", R.drawable.asphalt9) ,
            Game("Mario Cart", R.drawable.mario)
        )
        "shooters" -> listOf(
            Game("Call of Duty", R.drawable.cod),
            Game("Overwatch", R.drawable.overwatch),
            Game("Apex Legends", R.drawable.apex_legends) ,
            Game("Fortnite", R.drawable.fortnite)
        )
        "rpgs" -> listOf(
            Game("Elden Ring", R.drawable.elden),
            Game("Skyrim", R.drawable.skyrim),
            Game("The Witcher 3", R.drawable.witcher3),
            Game("Final Fantasy", R.drawable.final_fantasy)
        )
        "sports" -> listOf(
            Game("FC 25", R.drawable.fifa),
            Game("NBA 2K", R.drawable.nba2k),
            Game("Rocket League", R.drawable.rocket_league),
            Game("e-football", R.drawable.messi),
        )


    else -> emptyList()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
       Row(verticalAlignment = Alignment.CenterVertically) {
           Box(){
               IconButton(
                   onClick = { navController.popBackStack() },
                   modifier = Modifier
                       .padding(4.dp)
                       .align(Alignment.TopStart)
               ) {
                   Icon(
                       imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                       contentDescription = "Back"
                   )
           }
           }


           Text(
               text = " $category",
               fontSize = 32.sp,
               modifier = Modifier.fillMaxWidth()
                   .padding(top = 6.dp) ,
               color = MaterialTheme.colorScheme.onPrimary
           )
       }
        Spacer(modifier = Modifier.height(8.dp))

        HorizontalDivider(color = Color.White.copy(alpha = 0.5f)  , thickness = 1.dp , modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(8.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(games) { game ->
                GameCard(game = game , onClick = { navController.navigate("tips/Mortal Kombat")})
            }
        }
    }
}


