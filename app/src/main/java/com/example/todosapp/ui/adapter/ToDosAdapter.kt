package com.example.todosapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todosapp.data.entity.ToDos
import com.example.todosapp.databinding.CardDesingBinding
import com.example.todosapp.databinding.SaveScreenBinding
import com.example.todosapp.ui.screens.MainScreenDirections
import com.example.todosapp.ui.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class ToDosAdapter(var mContext: Context,
                   var toDosList: List<ToDos>,
                   var viewModel: MainViewModel) :
    RecyclerView.Adapter<ToDosAdapter.CardDesingHolder>() {

    inner class CardDesingHolder(var binding: CardDesingBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesingHolder {
        val binding = CardDesingBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesingHolder(binding)

    }

    override fun onBindViewHolder(holder: CardDesingHolder, position: Int) {
        val toDo = toDosList.get(position)
        val design = holder.binding

        design.textViewName.text =toDo.name

        design.cardViewToDo.setOnClickListener {
            val toUpdateScreen = MainScreenDirections.toUpdateScreen(toDo = toDo)
            it.findNavController().navigate(toUpdateScreen)
        }

        design.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Do you want to delete ${toDo.name} ? ", Snackbar.LENGTH_SHORT)
                .setAction("Yes") {
                    viewModel.delete(toDo.id)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return toDosList.size
    }
}