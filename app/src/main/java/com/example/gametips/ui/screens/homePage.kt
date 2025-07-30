package com.example.gametips.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.gametips.R
import com.example.gametips.ui.components.BottomFeatureCard
import com.example.gametips.ui.components.IconTextCard
import com.example.gametips.ui.components.TipCardWithOverlay

@Composable
fun HomePage(innerPadding : PaddingValues){

    val searchInput: MutableState<String> = remember {mutableStateOf("")}


    val Lobster = FontFamily(Font(R.font.lobster_regular , FontWeight.Normal))

    Column (
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)

        ){

            AsyncImage(
                model = R.drawable.header ,
                contentDescription = "banner image" ,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Column {

                    Text(
                        text = "GameTips" ,
                        fontSize = 48.sp,
                        fontFamily = Lobster,
                        textAlign = TextAlign.Center ,
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 20.dp) ,
                        color = MaterialTheme.colorScheme.onPrimary
                    )




                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)

                ){
                    OutlinedTextField(
                        value = searchInput.value,
                        onValueChange = { newValue -> searchInput.value = newValue },
                        placeholder = {Text("Search...")},
                        modifier = Modifier
                            .background(Color.Transparent)
                            .padding(vertical = 10.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White.copy(alpha = 0.9f),
                            unfocusedContainerColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.White,
                            focusedIndicatorColor = Color.Black ,
                            unfocusedIndicatorColor = Color.White
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "search icon",
                            )
                        }
                    )
                }




            }

        }

        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            IconTextCard(category = "Racing", image = R.drawable.sport_car)

            IconTextCard(category = "FPS" , image = R.drawable.gun)

            IconTextCard(category = "Fighting" , image = R.drawable.swords)
            IconTextCard(category = "RPG" , image = R.drawable.icons8_elden_ring)
            IconTextCard(category = "Sports" , image = R.drawable.balls_sports)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Trending Updates" ,
                fontSize = 24.sp ,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "see all",
                color =MaterialTheme.colorScheme.onPrimary ,
                fontSize = 22.sp
            )

        }
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {

            TipCardWithOverlay(
                gameTitle = "mk" ,
                tipText = "Tips for latest update" ,
                imageUrl = R.drawable.scorpion
            )
            TipCardWithOverlay(
                gameTitle = "Call of Duty" ,
                tipText = "Get Recommended gear" ,
                imageUrl = R.drawable.ghost
            )
            TipCardWithOverlay(
                gameTitle = "e-football" ,
                tipText = "How to outperform opponent" ,
                imageUrl = R.drawable.messi
            )

        }

        Text(
            text = "Latest Features" ,
            fontSize = 28.sp ,
            fontWeight = FontWeight.Bold ,
            modifier = Modifier.padding(16.dp)
        )

        Column () {
            BottomFeatureCard(
                image = R.drawable.note ,
                title = "Beginner's page" ,
                aboutText = "Best place to begin your gaming career",
                added = "1 week ago"
            )
            BottomFeatureCard(
                image = R.drawable.army ,
                title = "Loadout checker" ,
                aboutText = "Get the best loadout suggestions done by AI",
                added = "1 day ago"
            )
            BottomFeatureCard(
                image = R.drawable.hide ,
                title = "Hide online " ,
                aboutText = "you can now hide your status while browsing",
                added = "2 days ago"
            )
            BottomFeatureCard(
                image = R.drawable.soccer ,
                title = "Patch Notes" ,
                aboutText = "Get the patch notes for all your favourite games",
                added = "1 week ago"
            )

        }




    }


}