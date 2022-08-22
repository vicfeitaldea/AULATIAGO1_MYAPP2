package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Carro
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CarrosViewModel : ViewModel() {
    var carros = MutableLiveData<List<Carro>>()

    var msg = MutableLiveData<String>()

    init {
         //consumir firebase
        val firestore = Firebase.firestore
        val collection = firestore.collection("carros")
        val task = collection.get()

        task.addOnFailureListener{
            msg.value = it.message
        }.addOnSuccessListener {
            carros.value = it.toObjects(Carro::class.java)
        }

    }
}