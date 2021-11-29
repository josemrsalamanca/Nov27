package com.example.loginintento7.authentication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.loginintento7.R
import com.example.loginintento7.authentication.presentation.LoginViewModel
import com.example.loginintento7.databinding.FragmentLoginBinding
//kkk
class LoginFragment : Fragment() {
    // PASO 1: IMPLEMENTAR VIEW MODEL
    private val loginViewModel: LoginViewModel by activityViewModels() // de aristides
    private var rawBinding: FragmentLoginBinding? = null
    private val binding get() = rawBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rawBinding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListener()
        setupViewModel()
    }

    private fun setupViewModel() {
        // donde esta el viewlife, antes tenía this, pero el ide recomienda cambiarlo
        loginViewModel.state().observe(viewLifecycleOwner){
            it?.let{safeState->
                renderUI(safeState)
            }
        }
    }

    private fun renderUI(safeState: String) {
        Toast.makeText(context,safeState,Toast.LENGTH_LONG).show()
    }

    private fun setupClickListener() {
        binding?.btnLogin?.setOnClickListener {
            val usuario= binding!!.edtCorreo.text.toString()
            val contraseña= binding!!.edtContrasenia.text.toString()

            loginViewModel.login(usuario,contraseña)
            //loginViewModel.login(getUser(),getPassword())
        }
        binding?.btnRegistro?.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registroFragment)
        }
    }

    //private fun getUser() = binding?.edtCorreo?.text.toString()
    //private fun getPassword() = binding?.edtContrasenia?.text.toString()
}

