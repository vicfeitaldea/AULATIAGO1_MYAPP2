package com.example.myapplication.detalhes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CarroDetalheViewModelFactory(val documentId: String)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CarroDetalheViewModel(documentId) as T
    }
}