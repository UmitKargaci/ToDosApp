package com.example.todosapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todosapp.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(var toDosRepository : ToDosRepository) : ViewModel() {

    fun update(id: Int, name: String){
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.update(id,name)
        }
    }
}