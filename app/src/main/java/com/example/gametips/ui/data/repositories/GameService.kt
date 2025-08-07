package com.example.gametips.ui.data.repositories

import com.example.gametips.ui.data.models.Tips

interface GameService {
    fun getTips(onResult: (List<Tips>)-> Unit)
    fun addGame(tips: Tips, onComplete: () -> Unit, onError: (Exception) -> Unit)
}