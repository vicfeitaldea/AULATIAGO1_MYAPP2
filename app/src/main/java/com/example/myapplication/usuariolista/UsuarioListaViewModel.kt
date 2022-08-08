package com.example.myapplication.usuariolista

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.UsuarioDAO.UsuarioDAO
import com.example.myapplication.model.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioListaViewModel(
    val usuarioDAO: UsuarioDAO) : ViewModel() {

    var usuarios = MutableLiveData<List<Usuario>>()

    init {
        viewModelScope.launch(Dispatchers.Default) {
            var usuariosDaBase = usuarioDAO.listar()
            usuarios.postValue(usuariosDaBase)
        }
    }
}