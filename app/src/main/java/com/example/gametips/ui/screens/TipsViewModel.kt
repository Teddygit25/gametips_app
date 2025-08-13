package com.example.gametips.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gametips.ui.data.models.Tips
import com.example.gametips.ui.data.repositories.GamesRepositories
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TipsViewModel: ViewModel() {

    // states
    private val _tips = MutableStateFlow<List<Tips>>(listOf())
    val tip: StateFlow<List<Tips>> get() = _tips

    private val repo = GamesRepositories() // instance of the places repository
    private val db = FirebaseFirestore.getInstance()
    // methods
    fun getTips(tipper:String)
    {
        repo.getTips {
            _tips.value = it
        }
    }




//    fun addTips(tips: Tips) {
//        repo.addGame(
//            tips,
//            onComplete = {getTips(tippers = "")} ,
//            onError = {e -> e.printStackTrace()}
//        )
//    }

    fun addTips(tips: Tips){
        repo.addGame(tips){success ->
            if (success){
                getTips(tipper = "")
            }else{
                println("failed to add tip")
            }
        }
    }

    fun deleteTip(tipId: String) {
        repo.deleteTip(tipId) { success ->
            if (success) {
                _tips.value = _tips.value.filterNot { it.id == tipId } // ✅ instantly update UI
            }
        }
    }






}