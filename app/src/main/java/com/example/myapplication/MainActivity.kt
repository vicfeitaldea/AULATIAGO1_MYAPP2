package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.example.myapplication.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firestore = Firebase.firestore
        var task = firestore
            .collection("produtos")
            .add(
                hashMapOf(
                    "nome" to "notebook",
                    "marca" to "Dell",
                    "valor" to 5000.00
                )
            )

        task.addOnSuccessListener {Toast.makeText(this, "", Toast.LENGTH_LONG).show()}
        task.addOnFailureListener {Toast.makeText(this, "", Toast.LENGTH_LONG).show()}

        // Room
//        var appDatabase = AppDatabase.getInstance(applicationContext)
//        var usuario = Usuario("Usuário 220803", "a@gmail", "a")
//        var usuarioDao = appDatabase.usuarioDao()
//
//        GlobalScope.launch {
//            usuarioDao.inserir(usuario)
//            Log.i("NovoUsuarioId", "Operação finalizada.")
//        }
        // var usuarioDao = UsuarioDao()
    }
}