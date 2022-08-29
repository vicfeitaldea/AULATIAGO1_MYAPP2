package com.example.myapplication.UsuarioDAO

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthDAO {
    companion object {
        //firebaseauthentication

        val auth = Firebase.auth

        fun getCurrentUser() = auth.currentUser

        // cadastrar usuarios
        //task
        fun cadastrarUsuario (
            email: String,
            senha: String): Task<AuthResult> {

            //firebase
            return auth
                .createUserWithEmailAndPassword(email, senha)

        }
        // validar usuarios

        fun validarUsuario(email: String, senha: String): Task<AuthResult> {
        return auth
            .signInWithEmailAndPassword(email, senha)

    }
  }
}