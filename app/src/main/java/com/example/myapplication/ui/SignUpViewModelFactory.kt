package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.UsuarioDAO.EnderecoDAO
import com.example.myapplication.UsuarioDAO.UsuarioDAO

class SignUpViewModelFactory(val usuarioDAO: UsuarioDAO, val enderecoDAO: EnderecoDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignUpViewModel(usuarioDAO, enderecoDAO) as T
    }
}