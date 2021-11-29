package com.example.loginintento7.authentication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.loginintento7.authentication.data.modelo.Usuario

@Dao
interface UsuarioDao {
    @Insert
    fun insertAll(vararg  usuario: Usuario)

    @Query("SELECT * FROM usuario WHERE nombre =:nombre and password =:password")
    fun findUserByPassword(nombre:String, password:String):Usuario

    @Query("SELECT * FROM usuario")
    fun getAllUsers(): List<Usuario>
}


