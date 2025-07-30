package com.example.gametips.ui.data.models

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavBar(
    val route : String ,
    val icon : ImageVector? = null ,
    val iconCustom : Painter ? = null
    )
