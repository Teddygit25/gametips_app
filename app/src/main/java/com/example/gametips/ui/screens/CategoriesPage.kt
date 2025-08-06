package com.example.gametips.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gametips.R
import com.example.gametips.ui.components.CategoryCardWithOverlay
import com.example.gametips.ui.components.FontFamilyLobster
import com.example.gametips.ui.components.Screen
import com.example.gametips.ui.data.models.GameCategoryNav


@Composable
fun CategoriesPage(navController : NavController){
    val categories = listOf(
        GameCategoryNav(
            name = "RACING" ,
            aboutText = "Get all racing game tips from Nfs to Blur " ,
            imageUrl = R.drawable.racing) ,
        GameCategoryNav(
            name = "SPORTS" ,
            aboutText = "Develop a perfect tackling skill in the field or even outmanoeuvre opponents" ,
            imageUrl = R.drawable.sports) ,
        GameCategoryNav(
            name = "FIGHTING" ,
            aboutText = "Struggling to learn combos, we got you covered in a variety of your favorite games" ,
            imageUrl = R.drawable.mk) ,
        GameCategoryNav(
            name = "SHOOTERS" ,
            aboutText = "Wanna learn how pros move and aim in combat , you're in the right place" ,
            imageUrl = R.drawable.shooters) ,
        GameCategoryNav(
            name = "RPGs" ,
            aboutText = "Lost in the vast world of elden ring , not to worry we've put down a full guide to it" ,
            imageUrl = R.drawable.rpg)



    )


    LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                FontFamilyLobster(text = "Get Good")

                Spacer(modifier = Modifier.height(8.dp))

                HorizontalDivider(color = Color.White.copy(alpha = 0.5f)  , thickness = 1.dp , modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(5.dp))
            }
            items(categories){ GameCategoryNav ->
                CategoryCardWithOverlay(category = GameCategoryNav , onClick = {
                    navController.navigate(Screen.GameList.createRoute(GameCategoryNav.name))
                })

            }
        }

//        Column {
//            CategoryCardWithOverlay(
//                name = "RACING" ,
//                aboutText = "Get all racing game tips from Nfs to Blur " ,
//                imageUrl = R.drawable.racing)
//            CategoryCardWithOverlay(
//                name = "SPORTS" ,
//                aboutText = "Develop a perfect tackling skill in the field or even outmanoeuvre opponents" ,
//                imageUrl = R.drawable.sports)
//            CategoryCardWithOverlay(
//                name = "FIGHTING" ,
//                aboutText = "Struggling to learn combos, we got you covered in a variety of your favorite games" ,
//                imageUrl = R.drawable.mk)
//             CategoryCardWithOverlay(
//                name = "SHOOTERS" ,
//                aboutText = "Wanna learn how pros move and aim in combat , you're in the right place" ,
//                imageUrl = R.drawable.shooters)
//             CategoryCardWithOverlay(
//                name = "RPGs" ,
//                aboutText = "Lost in the vast world of elden ring , not to worry we've put down a full guide to it" ,
//                imageUrl = R.drawable.rpg)
//
//
//
//        }



}