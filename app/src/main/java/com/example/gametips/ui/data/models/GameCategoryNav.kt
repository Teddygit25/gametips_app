package com.example.gametips.ui.data.models

import androidx.compose.ui.graphics.painter.Painter

data class GameCategoryNav(
    val name : String ,
    val  aboutText : String ? = null ,
    val imageUrl : Int ? = null ,
    val iconRes: Painter ? = null

)
