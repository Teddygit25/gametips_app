package com.example.gametips.ui.components

import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.gametips.R
import com.example.gametips.ui.data.models.Coach
import com.example.gametips.ui.data.models.Game
import com.example.gametips.ui.data.models.GameCategoryNav


@Composable
fun IconTextCard(
    category:String,
    image:Int ,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp) ,
        modifier = Modifier.padding(vertical = 6.dp , horizontal = 5.dp)
            .clip(RoundedCornerShape(30.dp))
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp) ,
            verticalAlignment = Alignment.CenterVertically ,
            modifier = Modifier.padding(8.dp)) {

            Image(
                painter = painterResource(image),
                contentDescription = "SVG icons" ,
                modifier = Modifier.size(28.dp)
            )
            Text(
                text = category
            )
        }
    }
}

@Composable
fun TipCardWithOverlay(
    gameTitle: String,
    tipText: String,
    imageUrl: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(270.dp)
            .width(180.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        // Background Image
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        // Dark overlay for readability
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0x80000000), Color(0xCC000000)),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )

        // Text content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .padding(16.dp) ,
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Bottom

        ) {
            Text(
                text = gameTitle,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = tipText,
                color = Color.White.copy(alpha = 0.9f),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis ,
                textAlign = TextAlign.Center

            )
        }
    }
}


@Composable
fun BottomFeatureCard(image : Int , title : String , aboutText : String , added : String ){
    Card (modifier = Modifier.fillMaxWidth()
           .height(90.dp)
        .padding(10.dp) ,
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
       Row {
           AsyncImage(
               model =  image,
               contentDescription = "SVG feature icons" ,
               modifier = Modifier.size(height = 100.dp , width = 100.dp)
           )
           Column {
               Text(
                   text = title ,
                   fontSize = 16.sp ,
                   fontWeight = FontWeight.ExtraBold
               )
               Text(
                   text = aboutText ,
                   fontSize = 12.sp ,
                   color = Color.LightGray ,
                   maxLines = 2,
                   overflow = TextOverflow.Ellipsis
               )
               Text(
                   text = added ,
                   fontSize = 12.sp ,
                   color = Color.Gray
               )
           }
       }
    }
}



@Composable
fun CategoryCardWithOverlay(
   category: GameCategoryNav ,
   onClick:() -> Unit ,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(200.dp)
            .clickable(onClick = onClick)
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))

    ) {
        // Background Image
        AsyncImage(
            model = category.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        // Dark overlay for readability
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0x80000000), Color(0xCC000000)),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )

        // Text content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .padding(16.dp) ,
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = category.name,
                fontSize = 32.sp ,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = category.aboutText,
                color = Color.White.copy(alpha = 0.5f),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis ,
                textAlign = TextAlign.Center

            )
        }
    }
}

@Composable
fun FontFamilyLobster(text : String){
    val Lobster = FontFamily(Font(R.font.lobster_regular , FontWeight.Normal))

    Text(
        text = text ,
        fontFamily = Lobster ,
        fontSize = 36.sp,
        textAlign = TextAlign.Center ,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 10.dp) ,
        color = MaterialTheme.colorScheme.onPrimary
    )

}

@Composable
fun GameCard(
    game: Game ,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(270.dp)
            .width(180.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        // Background Image
        AsyncImage(
            model = game.imageRes,
            contentDescription = null,
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        // Dark overlay for readability
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0x80000000), Color(0xCC000000)),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )

        // Text content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .padding(16.dp) ,
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Bottom

        ) {
            Text(
                text = game.name,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}


@Composable
fun CoachCard(coach: Coach ,onHireClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(180.dp)
            .height(240.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Background Image
            AsyncImage(
                model = coach.imageRes,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Gradient overlay at bottom
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f))
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.BottomStart)
                ) {
                    Text(coach.name, color = Color.White, fontWeight = FontWeight.Bold)
                    Text(coach.game, color = Color.White, style = MaterialTheme.typography.bodySmall)
                    Text(coach.price, color = Color.White, style = MaterialTheme.typography.bodySmall)

                    // ⭐ Ratings
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        repeat(coach.rating) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Star",
                                tint = Color.Yellow,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                        if (coach.rating < 5) {
                            repeat(5 - coach.rating) {
                                Icon(
                                    imageVector = Icons.Outlined.Star,
                                    contentDescription = "Empty Star",
                                    tint = Color.LightGray,
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }
                    }

                }

                Button(
                    onClick = onHireClick,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f))
                ) {
                    Text("Hire", color = Color.Black)
                }
            }
        }
    }
}


