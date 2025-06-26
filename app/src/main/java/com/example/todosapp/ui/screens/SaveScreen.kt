package com.example.todosapp.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todosapp.R
import com.example.todosapp.databinding.SaveScreenBinding
import com.example.todosapp.ui.viewmodel.SaveViewModel
import com.example.todosapp.ui.viewmodel.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class SaveScreen : Fragment() {
    private lateinit var binding: SaveScreenBinding
    private lateinit var viewModel: SaveViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SaveScreenBinding.inflate(inflater, container, false)

        binding.buttonSave.setOnClickListener {
            val name = binding.editTextName.text.toString()
            viewModel.save(name)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SaveViewModel by viewModels()
        viewModel = tempViewModel
    }
}