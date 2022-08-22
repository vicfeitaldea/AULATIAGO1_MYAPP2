package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.UsuarioDAO.EnderecoDAO
import com.example.myapplication.model.Usuario
import com.example.myapplication.UsuarioDAO.UsuarioDAO
import com.example.myapplication.model.Endereco


@Database(
    entities = arrayOf(Usuario::class, Endereco::class),
    version = 1
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDAO

    abstract fun enderecoDao(): EnderecoDAO


    companion object {

        //uma propriedade do tipo da classe
        private var INSTANCE: AppDataBase? = null

        //uma funçao que verifica se a propriedade é nula
         //SE SIM, INSTANCIA RETORNA A MESMA
        fun getInstance(context: Context) : AppDataBase {
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "dabatase.db"
        ).allowMainThreadQueries()
            .build()
            }

            return INSTANCE as AppDataBase
        }

    }

}