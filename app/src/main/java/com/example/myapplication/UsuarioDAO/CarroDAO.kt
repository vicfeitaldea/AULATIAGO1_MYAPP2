package com.example.myapplication.UsuarioDAO

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CarroDAO {
    companion object{
        private val collection = Firebase
            .firestore.collection("carros")
        fun listar() = collection.get()
    }

}