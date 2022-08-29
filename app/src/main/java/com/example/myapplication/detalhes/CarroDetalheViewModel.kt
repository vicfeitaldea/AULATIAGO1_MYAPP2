package com.example.myapplication.detalhes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.UsuarioDAO.CarroDAO
import com.example.myapplication.model.Carro

class CarroDetalheViewModel(val documentId: String) : ViewModel() {

    val carro = MutableLiveData<Carro>()
    val status = MutableLiveData<Boolean>()
    val msg = MutableLiveData<String>()

    init{
        val task = CarroDAO.exibir(documentId)
        task.addOnSuccessListener {
            carro.value = it.toObject(Carro::class.java)
        }.addOnFailureListener {
            msg.value = it.message
        }
    }

    fun excluir() {
        val task = CarroDAO.excluir(documentId)

        task.addOnSuccessListener {
            status.value = false

        }.addOnFailureListener {
            msg.value = it.message
        }
    }
}