package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Endereco (
    val logradouro: String?,
    val numero: Int?,
    val usuarioId: Long?,
    @PrimaryKey val id: Long? = null
){}