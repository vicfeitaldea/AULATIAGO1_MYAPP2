package com.example.myapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentCarroFormBinding
import com.example.myapplication.databinding.FragmentCarrosBinding

class CarroFormFragment : Fragment() {

    var _binding: FragmentCarroFormBinding? = null
    val binding get() = _binding!!
    private lateinit var viewModel: CarroFormViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarroFormBinding.inflate(inflater, container, false)
        val root = binding.root
        viewModel = ViewModelProvider(this).get(CarroFormViewModel::class.java)

        binding.button.setOnClickListener {
            val marca = binding.editTextmarca.text.toString()
            val modelo = binding.editTextmodelo.text.toString()
            val placa = binding.editTextplaca.text.toString()
            viewModel.salvar(marca, modelo, placa)
        }
        return root
    }
}