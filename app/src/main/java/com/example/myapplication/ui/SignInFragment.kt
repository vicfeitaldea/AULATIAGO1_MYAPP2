package com.example.myapplication.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.UsuarioDAO.AuthDAO.Companion.auth
import com.example.myapplication.database.AppDataBase
import com.example.myapplication.databinding.SignInFragmentBinding
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider


class SignInFragment : Fragment() {

    private var callbackManager: CallbackManager? = null

    private var _binding: SignInFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SignInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SignInFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        val view = binding.root

        val appDataBase = AppDataBase.getInstance(requireContext())
        val usuarioDAO = appDataBase.usuarioDao()
        val factory = SignInViewModelFactory(usuarioDAO)

        callbackManager = CallbackManager.Factory.create()

        binding.loginbutton.setReadPermissions("email", "public_profile")
        binding.loginbutton.registerCallback(callbackManager, object :
            FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                handleFacebookAccessToken(loginResult.accessToken)
            }

            override fun onCancel() {
            }

            override fun onError(error: FacebookException) {
            }
        })

        viewModel = ViewModelProvider(this, factory).get(SignInViewModel::class.java)

        viewModel.status.observe(viewLifecycleOwner){
            if(it)
                findNavController()
                    .navigate(R.id.homeFragment)
        }

        lerPref(binding.edtTxtSigninEmail)

        binding.btnSignInAcessar.setOnClickListener {
            val email = binding.edtTxtSigninEmail.text.toString()
            val password = binding.edtTxtSigninSenha.text.toString()
            val lembrar = binding.cbSigninLembrar.isChecked
            if (lembrar){
                salvarPref(email)
            }

            viewModel.autenticar(email, password)

        }

        binding.txtVwSignupLink.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }

        return view
    }

    private fun handleFacebookAccessToken(token: AccessToken) {

        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(requireContext(), "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
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