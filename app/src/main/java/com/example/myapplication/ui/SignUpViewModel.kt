package com.example.dka.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.UsuarioDAO.UsuarioDAO
import com.example.myapplication.model.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {
    fun salvarUsuario(
        usuarioDAO: UsuarioDAO,
        nome: String, email: String, senha: String){
        val usuario = Usuario(nome, email, senha)
        viewModelScope
            .launch(Dispatchers.Default) {
                usuarioDAO.inserir(usuario)
            }
    }}