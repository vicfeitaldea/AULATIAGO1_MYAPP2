package com.example.dka

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.example.myapplication.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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