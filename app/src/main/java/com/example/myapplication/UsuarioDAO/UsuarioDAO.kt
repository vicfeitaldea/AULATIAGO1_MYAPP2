package com.example.myapplication.UsuarioDAO

import androidx.room.*
import com.example.myapplication.model.Usuario


@Dao
interface UsuarioDAO {

    // listar todos os usuários
    @Query("SELECT * FROM Usuario")
     fun listar(): List<Usuario>

    // inserir
    @Insert // INSERT INTO usuario
     fun inserir(usuario: Usuario)

    // exibir um usuario
    @Query("SELECT * FROM Usuario WHERE id = :id")
     fun exibir(id: Int) : Usuario

    // atualizar um usuário
    @Update
     fun atualizar(usuario: Usuario)

    // excluir um usuario
    @Delete
     fun excluir(usuario: Usuario)
    //

}