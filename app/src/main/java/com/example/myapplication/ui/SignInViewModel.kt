package com.example.myapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.UsuarioDAO.UsuarioDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel(val usuarioDao: UsuarioDAO) : ViewModel() {

    val status = MutableLiveData<Boolean>()
    val msg = MutableLiveData<String>()

    init{
        status.value = false
    }

    fun autenticar(email: String, senha: String){
        viewModelScope.launch (Dispatchers.Default) {
            try {
                val usuario = usuarioDao.autenticar(email, senha)
                if(usuario != null)
                    status.postValue(true)
                else{
                    status.postValue(false)
                    msg.postValue("Usuário inválido")
                }
            } catch (err: Exception){
                status.postValue(false)
                msg.postValue("Usuário inválido")
            }
        }
    }

}