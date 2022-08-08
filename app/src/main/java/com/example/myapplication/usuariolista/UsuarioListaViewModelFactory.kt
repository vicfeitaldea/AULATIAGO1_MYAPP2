package com.example.myapplication.usuariolista

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.UsuarioDAO.UsuarioDAO

class UsuariosListaViewModelFactory (val usuarioDao: UsuarioDAO)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsuarioListaViewModel(usuarioDao) as T
    }
}