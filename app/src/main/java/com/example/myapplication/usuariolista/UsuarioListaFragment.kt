package com.example.myapplication.usuariolista

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.database.AppDataBase
import com.example.myapplication.databinding.UsuarioListaFragmentBinding

class UsuarioListaFragment : Fragment() {

    lateinit var usuariosListaViewModelFactory: UsuariosListaViewModelFactory

    private var _binding: UsuarioListaFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UsuarioListaViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = UsuarioListaFragmentBinding
            .inflate(inflater, container, false)
        val view = binding.root
        val appDataBase = AppDataBase.getInstance(requireContext())
        val usuarioDAO = appDataBase.usuarioDao()

        usuariosListaViewModelFactory = UsuariosListaViewModelFactory(usuarioDAO)
        viewModel = ViewModelProvider(this, usuariosListaViewModelFactory)
            .get(UsuarioListaViewModel::class.java)


        viewModel.usuarios.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty())
                Toast.makeText(requireContext(),
                "${it.size}",
                    Toast.LENGTH_LONG)
                    .show()
        }

        return view

    }

}