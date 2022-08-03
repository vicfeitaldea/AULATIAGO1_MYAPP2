package com.example.dka.ui.signin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dka.databinding.FragmentFilesBinding
import com.example.dka.databinding.FragmentSignInBinding
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSignInBinding
import com.example.myapplication.ui.SignInViewModel

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SignInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        val view = binding.root
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)

        lerPref(binding.edtTxtSigninEmail)

        binding.btnSignInAcessar.setOnClickListener {
            val email = binding.edtTxtSigninEmail.text.toString()
            val password = binding.edtTxtSigninSenha.text.toString()
            val lembrar = binding.cbSigninLembrar.isChecked
            if (lembrar){
                salvarPref(email)
            }
        }

        binding.txtVwSignupLink.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }

        return view
    }

    fun lerPref(edtText: EditText){
        // Ler para ver se tem algum email
        val pref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        val email = pref.getString("email", null)
        edtText.setText(email)
    }

    fun salvarPref(email: String){
        val pref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (pref.edit()) {
            putString("email", email)
            apply()
        }
    }

}