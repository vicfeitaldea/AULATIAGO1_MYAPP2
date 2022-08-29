package com.example.myapplication.UsuarioDAO

import com.example.myapplication.model.Carro
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CarroDAO {
    companion object{
        private val collection = Firebase
            .firestore.collection("carros")
        fun listar() = collection.get()
        fun inserir(carro: Carro) = collection.add(carro)
        fun exibir(documentId: String) = collection.document(documentId).get()
        fun excluir(documentId: String) = collection.document(documentId).delete()
        fun atualizar(documentId: String, carro: Carro) = collection.document(documentId).set(carro)
    }

}