package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dka.ui.files.FilesViewModel
import com.example.myapplication.databinding.FilesFragmentBinding
import java.io.File

class FilesFragment : Fragment() {

    private var _binding: FilesFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: FilesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FilesFragmentBinding.inflate(inflater, container, false)
        var view = binding.root
        viewModel = ViewModelProvider(this).get(FilesViewModel::class.java)

        binding.lifecycleOwner = this
        binding.filesViewModel = viewModel

        // Verifica o arquivo
        binding.btnVerificarArquivo.setOnClickListener {
            val nomeArquivo = binding.edtTextArquivoNome.text.toString()
            val arquivo = File(requireContext().filesDir, nomeArquivo)
            if (arquivo.exists()) {
                viewModel.estado.value = "Existe"
                requireContext().openFileInput(
                    nomeArquivo
                ).use { fis ->
                    val conteudo = fis
                        .bufferedReader()
                        .readText()
//                    binding.edtTxtConteudoArquivo.setText(conteudo)
                    viewModel.conteudo.value = conteudo
                }
            }
            else viewModel.estado.value = "Não Existe"
        }

        binding.btnCriarArquivo.setOnClickListener {
            val nomeArquivo = binding.edtTextArquivoNome.text.toString()
            val arquivo = File(requireContext().filesDir, nomeArquivo)
            if (arquivo.createNewFile()) viewModel.estado.value = "Arquivo criado."
            else viewModel.estado.value = "Arquivo não foi criado."
        }

        binding.btnSalvar.setOnClickListener {
            val context = requireContext()
            val conteudoArquivo = binding.edtTxtConteudoArquivo.text.toString() + "\n"
            val nomeArquivo = binding.edtTextArquivoNome.text.toString()
            context.openFileOutput(nomeArquivo, Context.MODE_PRIVATE).use {
                it.write(conteudoArquivo.toByteArray())
            }
        }

        return view
    }
}