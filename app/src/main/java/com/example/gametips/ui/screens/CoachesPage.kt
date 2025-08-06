package com.example.gametips.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gametips.R
import com.example.gametips.ui.components.CoachCard
import com.example.gametips.ui.components.FontFamilyLobster
import com.example.gametips.ui.data.models.Coach


@Composable
fun CoachesPage(){
    val context = LocalContext.current

    val coaches = listOf(
        Coach("Shadow", "MK11", "$10/hr",R.drawable.scorpion , 5),
        Coach("Luna", "Tekken", "$12/hr", R.drawable.cod, 4),
        Coach("Nova", "S Fighter", "$8/hr", R.drawable.street_fighter, 3),
        Coach("Reign", "Injustice", "$15/hr", R.drawable.messi, 5)
    )

    Column(modifier = Modifier.fillMaxSize()) {
            FontFamilyLobster(text = "Get Coach")

            Spacer(modifier = Modifier.height(8.dp))

            HorizontalDivider(color = Color.White.copy(alpha = 0.5f)  , thickness = 1.dp , modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(5.dp))


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(coaches) { coach ->
                CoachCard(coach = coach) {
                    Toast.makeText(
                        context,
                        "Hired ${coach.name}!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }






}