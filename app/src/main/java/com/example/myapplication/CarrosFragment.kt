package com.example.myapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.myapplication.databinding.FragmentCarrosBinding
import com.google.android.material.snackbar.Snackbar

class CarrosFragment : Fragment() {

    var _binding: FragmentCarrosBinding? = null
    val binding get() = _binding!!
    private lateinit var viewModel: CarrosViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarrosBinding.inflate(inflater, container, false)
        val root = binding.root

        viewModel = ViewModelProvider(this).get(CarrosViewModel::class.java)
        //observe

        viewModel.carros.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()){
                binding.listViewCarro.adapter = ArrayAdapter(
                    requireContext(), android.R.layout.simple_list_item_1,
                    it
                )
            } else {
                showSnackbar(root, "A lista está vazia")
            }
        }
        viewModel.msg.observe(viewLifecycleOwner) {
            if (it.isNotBlank())
                showSnackbar(root, it)
        }

        return root
    }

    private fun showSnackbar(root: View, msg: String) {
        Snackbar.make(root, msg, Snackbar.LENGTH_LONG).show()
    }

}