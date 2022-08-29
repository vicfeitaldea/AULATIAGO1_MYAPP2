package com.example.myapplication.detalhes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.google.android.material.snackbar.Snackbar

class CarroDetalheFragment : Fragment() {

    private lateinit var viewModel: CarroDetalheViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val documentId = arguments?.getString("documentId")

        val view = inflater.inflate(R.layout.fragment_carro_detalhe, container, false)
        val factory = CarroDetalheViewModelFactory(documentId!!)
        viewModel = ViewModelProvider(this, factory)
            .get(CarroDetalheViewModel::class.java)

        viewModel.status.observe(viewLifecycleOwner){
            if (it)
                findNavController().popBackStack()
        }

        viewModel.msg.observe(viewLifecycleOwner){
            if(it.isNotBlank())
                Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
        }

        viewModel.carro.observe(viewLifecycleOwner){
            if(it != null){
                view.findViewById<TextView>(R.id.textViewCarroPlaca).text = it.placa
                view.findViewById<TextView>(R.id.textViewCarroMarca).text = it.marca
                view.findViewById<TextView>(R.id.textViewCarroModelo).text = it.modelo
            }
        }

        view.findViewById<Button>(R.id.btnExcluirCarro).setOnClickListener {
            viewModel.excluir()
        }

        view.findViewById<Button>(R.id.btnEditarCarro).setOnClickListener {
            findNavController().navigate(R.id.carroFormFragment,
                bundleOf("documentId" to documentId))
        }

        return view
    }

}