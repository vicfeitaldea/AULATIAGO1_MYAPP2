package com.example.myapplication.UsuarioDAO

import androidx.room.*
import com.example.myapplication.model.Endereco

@Dao
interface EnderecoDAO {

    @Query("SELECT * FROM Endereco")
    fun listar(): List<Endereco>

    @Insert
    fun inserir(endereco: Endereco): Long

    @Query("SELECT * FROM Endereco WHERE id = :id")
    fun exibir(id: Long) : Endereco

    @Update
    fun atualizar (endereco: Endereco)

    @Delete
    fun excluir(endereco: Endereco)
}