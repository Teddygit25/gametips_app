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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.gametips.R
import com.example.gametips.ui.components.BottomFeatureCard
import com.example.gametips.ui.components.IconTextCard
import com.example.gametips.ui.components.Screen
import com.example.gametips.ui.components.TipCardWithOverlay
import com.example.gametips.ui.data.models.GameCategoryNav
import com.example.gametips.ui.data.models.HomeNav

@Composable
fun HomePage(innerPadding : PaddingValues , navController:NavHostController){

    val categories = listOf(
        GameCategoryNav(
            name = "Racing" ,
            iconRes = painterResource(R.drawable.sport_car)
        ) ,
        GameCategoryNav(
            name = "Sports" ,
            iconRes = painterResource(R.drawable.balls_sports) ) ,
        GameCategoryNav(
            name = "Fighting" ,
            iconRes = painterResource(R.drawable.swords) ) ,
        GameCategoryNav(
            name = "Shooters" ,
            iconRes = painterResource(R.drawable.gun)) ,
        GameCategoryNav(
            name = "RPGs" ,
            iconRes = painterResource(R.drawable.icons8_elden_ring))



    )

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
                            .padding(top = 10.dp),
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

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(categories){item ->
                IconTextCard(category = item , onClick = {navController.navigate(Screen.GameList.createRoute(item.name))})
            }



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