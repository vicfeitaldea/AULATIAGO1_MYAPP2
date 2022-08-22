package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.UsuarioDAO.UsuarioDAO

class SignInViewModelFactory(val usuarioDAO: UsuarioDAO) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignInViewModel(usuarioDAO) as T
    }
}