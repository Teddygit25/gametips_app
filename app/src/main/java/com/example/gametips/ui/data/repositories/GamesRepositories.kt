package com.example.gametips.ui.data.repositories

import android.util.Log
import com.example.gametips.ui.data.models.Tips
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore

class GamesRepositories:GameService {
    private val db = FirebaseFirestore.getInstance()
    private val gamesCollection = db.collection("Games")

    override fun getTips(onResult: (List<Tips>) -> Unit) {
        gamesCollection.get()
            .addOnSuccessListener { snapshot ->
                val gameList = snapshot.toObjects(Tips::class.java)
                onResult(gameList)
            }
            .addOnFailureListener { onResult(emptyList()) }
    }

    override fun addGame(tips: Tips, onComplete: () -> Unit, onError: (Exception) -> Unit) {
        gamesCollection.add(tips)
            .addOnSuccessListener {
                Log.d("Firestore" , "Game added with ID: ${it.id}")
            }
            .addOnFailureListener{e ->
                Log.e("Firestore" , "Error adding game" , e)
            }
    }
}