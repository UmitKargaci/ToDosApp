package com.example.todosapp.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todosapp.R
import com.example.todosapp.databinding.MainScreenBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todosapp.data.entity.ToDos
import com.example.todosapp.ui.adapter.ToDosAdapter
import com.example.todosapp.ui.viewmodel.MainViewModel
import com.example.todosapp.ui.viewmodel.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text
import kotlin.getValue

@AndroidEntryPoint
class MainScreen : Fragment() {
    private lateinit var binding: MainScreenBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainScreenBinding.inflate(inflater, container, false)

        viewModel.toDosList.observe(viewLifecycleOwner) {
            val toDosAdapter = ToDosAdapter(requireContext(), it,viewModel)
            binding.recyclerViewToDos.adapter = toDosAdapter
        }


        binding.recyclerViewToDos.layoutManager = LinearLayoutManager(requireContext())

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }
        })

        binding.fab.setOnClickListener {
            it.findNavController().navigate(R.id.toSaveScreen)

        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadToDos()
    }

}