package com.example.loginintento7.authentication.data.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(
    @PrimaryKey
    val nombre: String,
    val nombrecompleto:String,
    val password: String
)
