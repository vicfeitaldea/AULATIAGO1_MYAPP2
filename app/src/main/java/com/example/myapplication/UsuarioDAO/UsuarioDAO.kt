package com.example.myapplication.UsuarioDAO

import androidx.room.*
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
    @Query("SELECT * FROM Usuario WHERE id = :id ") //AND nome = :nome
    fun exibir(id: Int): Usuario

    //atualizar um usuario
    @Update
    fun atualizar(usuario: Usuario)

    //excluir um usuario
    @Delete
    fun exclur(usuario: Usuario)
}