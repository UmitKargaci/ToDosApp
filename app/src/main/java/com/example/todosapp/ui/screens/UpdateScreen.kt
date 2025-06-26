package com.example.todosapp.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todosapp.R
import com.example.todosapp.databinding.UpdateScreenBinding
import com.example.todosapp.ui.viewmodel.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateScreen : Fragment() {
    private lateinit var binding: UpdateScreenBinding
    private lateinit var viewModel: UpdateViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = UpdateScreenBinding.inflate(inflater, container, false)

        val bundle: UpdateScreenArgs by navArgs()
        val toDo = bundle.toDo

        binding.editTextName.setText(toDo.name)

        binding.buttonUpdate.setOnClickListener {
            val name = binding.editTextName.text.toString()
            viewModel.update(toDo.id,name)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: UpdateViewModel by viewModels()
        viewModel = tempViewModel
    }

}