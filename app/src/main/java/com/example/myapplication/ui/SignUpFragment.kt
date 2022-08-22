package com.example.myapplication.ui

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.database.AppDataBase
import com.example.myapplication.databinding.SignUpFragmentBinding
import com.example.myapplication.model.Usuario
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
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

        //FirebaseStorage
        val firebaseStorage = Firebase.storage
        val imagem = firebaseStorage.reference.child("apple-logo-1-1.png.")
        val task = imagem.getBytes(1024+1024)
        task.addOnCompleteListener{
            Toast.makeText(requireContext(), "tarefa terminada", Toast.LENGTH_LONG).show()
        }

        task.addOnSuccessListener {
            Toast.makeText(requireContext(), "tarefa realizada", Toast.LENGTH_LONG).show()
        }

        task.addOnFailureListener{
                Toast.makeText(requireContext(), "tarefa falhou", Toast.LENGTH_LONG).show()
        }

        binding.imageViewCadastro.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,123456)
        }

        viewModel.status.observe(viewLifecycleOwner){
            if(it)
                findNavController().popBackStack()
        }

        binding.btnSignupAcessar.setOnClickListener {
            val nome = binding.edtTxtSignupNome.text.toString()
            val email = binding.edtTxtSignupEmail.text.toString()
            val logradouro = binding.edtTxtSignupEndereco.text.toString()
            val numero = binding.edtTxtSignupNumero.text.toString()
            val senha = binding.edtTxtSignupSenha.text.toString()
            val appDatabase = AppDataBase.getInstance(requireContext())
            val usuarioDao = appDatabase.usuarioDao()
            viewModel.salvarUsuario(nome, email, senha, logradouro, Integer.parseInt(numero))
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val imagem: Bitmap = data?.getParcelableExtra("data")!!
        binding.imageViewCadastro.setImageBitmap(imagem)
        viewModel.pegarFoto(imagem)
    }

}