package com.example.loginintento7.authentication.presentation

import android.app.Application
import androidx.lifecycle.*
import com.example.loginintento7.authentication.data.UsuarioDao
import com.example.loginintento7.authentication.data.modelo.BD
import com.example.loginintento7.authentication.data.modelo.Usuario
import kotlinx.coroutines.launch

class RegistroViewModel(application: Application): AndroidViewModel(application){
    private val usuarioDao : UsuarioDao
    init {
        val dataBase = BD.getDatabase(application)
        usuarioDao = dataBase.usuarioDao()
    }

    private val mutableLiveData = MutableLiveData<String>()
    fun state():LiveData<String> = mutableLiveData

    fun registraUsuario(nombre:String, password:String, nombreCompleto:String){
        viewModelScope.launch {
            usuarioDao.insertAll(Usuario(nombre,nombreCompleto,password))
            val registro = usuarioDao.findUserByPassword(nombre, password)
             handleResponse(registro)
        }
    }


    private fun handleResponse(usuario: Usuario?) {
        if(usuario == null) {
            mutableLiveData.postValue("No se registro usuario")
        }else{
            mutableLiveData.postValue("Usuario: ${usuario.nombrecompleto}")
        }
    }
}