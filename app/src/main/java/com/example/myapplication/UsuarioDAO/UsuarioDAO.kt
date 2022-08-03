package com.example.myapplication.UsuarioDAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.model.Usuario


@Dao
interface UsuarioDAO {

    //listar todos os usuarios
    @Query("SELECT * FROM Usuario")

    fun listar() : List<Usuario>
    //inserir dados na porra da ta bela
    @Insert  //INSERT INTO USUARIO (CONSIDERANDO QUE O USUARIO É UMA ENTIDADE)
    fun inserir(usuario: Usuario)



    // exibir um usuario

    //atualizar um usuario

    //excluir um usuario
}