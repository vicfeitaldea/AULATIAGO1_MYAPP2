package com.example.myapplication

import androidx.lifecycle.ViewModel
import com.example.myapplication.UsuarioDAO.CarroDAO
import com.example.myapplication.model.Carro
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CarroFormViewModel : ViewModel() {
    fun salvar(marca: String, modelo: String, placa: String) {

        val carro = Carro(marca, modelo, placa)
        CarroDAO.inserir(carro)
//        Firebase.firestore
//            .collection("carros")
//            .add(mapOf(
//                "marca" to marca
//                "modelo" to modelo
//                "placa" to placa

    }
}