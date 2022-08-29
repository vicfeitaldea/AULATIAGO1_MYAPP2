package com.example.myapplication.ui

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.UsuarioDAO.AuthDAO
import com.example.myapplication.UsuarioDAO.EnderecoDAO
import com.example.myapplication.UsuarioDAO.UsuarioDAO
import com.example.myapplication.model.Endereco
import com.example.myapplication.model.Usuario
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream

class SignUpViewModel (val UsuarioDao: UsuarioDAO, val EnderecoDao: EnderecoDAO) : ViewModel() {
    val status = MutableLiveData<Boolean>()
    val msg = MutableLiveData<String>()
    var foto: Bitmap? = null

    init{
        status.value = false
    }

    fun pegarFoto(foto: Bitmap){
        this.foto = foto
    }

    fun salvarUsuario(
        nome: String, email: String, senha: String, ){

        val task = AuthDAO.cadastrarUsuario("vicfeital@gmail.com", "123")

        task.addOnSuccessListener {

        }.addOnFailureListener {
            msg.value = it.message
        }
//        val usuario = Usuario(nome, email, senha)
//        viewModelScope
//            .launch(Dispatchers.Default) {
//                val usuarioId = UsuarioDao.inserir(usuario)
//                val endereco = Endereco(logradouro, numero, usuarioId)
//                EnderecoDao.inserir(endereco)
//                uploadFoto(usuarioId)
//                status.postValue(true)
        // }
    }


    fun uploadFoto(id: Long){
        val referencia = Firebase.storage.reference.child("foto${id}.JPEG")
        val baos = ByteArrayOutputStream()
        this.foto?.compress(
            Bitmap.CompressFormat.JPEG,100,baos
        )
        var task = referencia.putBytes(baos.toByteArray())
        task.addOnSuccessListener { msg.value = "Usuário inserido com sucesso" }
        task.addOnFailureListener { msg.value = it.message }
    }
}