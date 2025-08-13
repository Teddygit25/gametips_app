package com.example.gametips.ui.data.repositories

import com.example.gametips.ui.data.models.Tips

interface GameService {
    fun getTips(onResult: (List<Tips>)-> Unit)
    fun addGame(tips: Tips, onResult: (Boolean) -> Unit)
    fun deleteTip(tipId: String, onResult: (Boolean) -> Unit)
}