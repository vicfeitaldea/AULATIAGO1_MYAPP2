package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

class Usuario (
    var nome: String?,
    var email: String?,
    var senha: String?,
    @PrimaryKey var id: Long? = null

)