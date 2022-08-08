package com.example.dka.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.database.AppDataBase
import com.example.myapplication.databinding.SignUpFragmentBinding
import com.example.myapplication.model.Usuario
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignUpFragment : Fragment() {

    private var _binding: SignUpFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SignUpFragmentBinding.inflate(inflater, container, false)

        val view = binding.root

        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        binding.btnSignupAcessar.setOnClickListener {
            val email = binding.edtTxtSignupEmail.text.toString()
            val senha = binding.edtTxtSignupSenha.text.toString()
            val appDatabase = AppDataBase.getInstance(requireContext())
            val usuarioDao = appDatabase.usuarioDao()
            GlobalScope.launch {
                usuarioDao.inserir(Usuario("Fulano", email, senha))
            }
        }

        return view
    }

}