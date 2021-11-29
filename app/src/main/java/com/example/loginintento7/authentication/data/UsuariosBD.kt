package com.example.loginintento7.authentication.data

import com.example.loginintento7.authentication.data.modelo.Usuario

@Deprecated("Ha sido deprecada")
object UsuariosBD {
    fun getUsuarios() : List<Usuario>{
        val usuarios = ArrayList<Usuario>()
        usuarios.add(crearUsuario("admin","admin","Nombre Completo del Usuario"))
        usuarios.add(crearUsuario("goku", "goku", "Nombre Completo del Usuario"))
        usuarios.add(crearUsuario("vegeta", "vegeta", "Nombre Completo del Usuario"))
        usuarios.add(crearUsuario("homero", "homero", "Homero Jay Simspon"))
        return usuarios
    }


    fun loginConUsuarioYPassword(user:String,password: String): Usuario? {
        var usuarioRetorno : Usuario? = null
        getUsuarios().forEach {usuario->
            if (usuario.password == password && usuario.nombre == user){
                usuarioRetorno = usuario
                return@forEach
            }
        }
        return usuarioRetorno
    }


    private fun crearUsuario(usuario: String, password: String, nombreCompleto: String) =  Usuario(usuario,nombreCompleto,password)
}