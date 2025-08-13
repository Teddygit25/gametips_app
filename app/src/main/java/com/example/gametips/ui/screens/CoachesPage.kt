package com.example.gametips.ui.screens

import android.graphics.Paint.Align
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.gametips.R
import com.example.gametips.ui.components.CoachCard
import com.example.gametips.ui.components.FontFamilyLobster
import com.example.gametips.ui.data.models.Coach


@Composable
fun CoachesPage(navController:NavHostController ){
    val context = LocalContext.current

    val coaches = listOf(
        Coach("Shadow", "MK11",
            "Shadow is a 19yr old Mk player he's been in this game since mk4 so you bet he's got the right skills when it comes to mortal kombat gameplay",
            "$10/hr",R.drawable.scorpion , 5),
        Coach("Luna", "Tekken",
            "Luna , 21yrs old and an absolute demon in what he does.He's won three world championships in Tekken and even taught the current world champ 'leveler' turning him into a pure protegee" ,
            "$12/hr", R.drawable.tekken, 4),
        Coach("Nova", "S Fighter",
            "Talk about a role model Hadoken thrower.Nova is in the coaches league now after conquering a number of gamers during his prime , now he wants to hone his skills as a coach.Hire him today and KO every fighter back to the alley"
            , "$8/hr", R.drawable.street_fighter, 3),
        Coach("Reign", "e-football",
            "Tackle,pass , run ,  shoot , score...all this and more are offered in a pro level by our very own Reign. After pulverising pple in last year's championships he wants to share his gift and turn pple like you into God like players."
            , "$15/hr", R.drawable.messi, 5)
    )

    // State for popup
    var selectedCoach by remember { mutableStateOf<Coach?>(null) }

    Column(modifier = Modifier.fillMaxSize()) {
            FontFamilyLobster(text = "Get Coach")

            Spacer(modifier = Modifier.height(8.dp))

            HorizontalDivider(color = Color.White.copy(alpha = 0.5f)  , thickness = 1.dp , modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(5.dp))


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(coaches) { coach ->
                CoachCard(coach = coach , onClick = {selectedCoach = coach} , onHireClick =  {
                    Toast.makeText(
                        context,
                        "Hired ${coach.name}!",
                        Toast.LENGTH_SHORT
                    ).show()
                })

            }
        }
    }

    // Popup Dialog
    if (selectedCoach != null) {
        Dialog(onDismissRequest = { selectedCoach = null }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    AsyncImage(
                        model = selectedCoach!!.imageRes,
                        contentDescription = selectedCoach!!.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop ,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = selectedCoach!!.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold ,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(text = selectedCoach!!.game)
                    Text(text = selectedCoach!!.bio , maxLines = 3 , overflow = TextOverflow.Ellipsis , modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth())
                    Text(text = selectedCoach!!.price)
                    Text(text = "⭐ ${selectedCoach!!.rating}/5")

                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = {
                            navController.navigate("payment/${selectedCoach!!.name}/${selectedCoach!!.game}")
                        }
                    ) {
                        Text("Hire Coach")
                    }
                }
            }
        }
    }






}