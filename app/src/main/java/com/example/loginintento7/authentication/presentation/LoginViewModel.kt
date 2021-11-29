package com.example.loginintento7.authentication.presentation

import android.app.Application
import androidx.lifecycle.*
import com.example.loginintento7.authentication.data.UsuarioDao
import com.example.loginintento7.authentication.data.modelo.Usuario
import com.example.loginintento7.authentication.data.UsuariosBD
import com.example.loginintento7.authentication.data.modelo.BD
import kotlinx.coroutines.launch


class LoginViewModel(application: Application) : AndroidViewModel(application){

    private val usuarioDao: UsuarioDao

    init {
        val dataBase = BD.getDatabase(application)
        usuarioDao = dataBase.usuarioDao()
    }
    private val mutableLiveData= MutableLiveData<String>()

    fun state(): LiveData<String> = mutableLiveData

    fun login(usuario:String,password:String){
        viewModelScope.launch {
            val usuario = usuarioDao.findUserByPassword(usuario,password)
            handleResponse(usuario)
            //val usuario = UsuariosBD.loginConUsuarioYPassword(usuario, password)
            //handleResponse(usuario)
        }
    }

    private fun handleResponse(usuario: Usuario?) {
        if(usuario!= null){
            mutableLiveData.postValue(usuario.nombrecompleto)
        }else{
            mutableLiveData.postValue("Usuario no existe")
        }
    }
}