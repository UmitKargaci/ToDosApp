package com.example.todosapp.data.repo

import android.util.Log
import com.example.todosapp.data.datasource.ToDosDataSource
import com.example.todosapp.data.entity.ToDos

class ToDosRepository (var toDosDataSource : ToDosDataSource){

    suspend fun save(name: String) = toDosDataSource.save(name)

    suspend fun update(id: Int, name: String) = toDosDataSource.update(id,name)

    suspend fun delete(id:Int) = toDosDataSource.delete(id)

    suspend fun loadToDos() : List<ToDos> = toDosDataSource.loadToDos()

    suspend fun search(searchText: String) : List<ToDos> = toDosDataSource.search(searchText)


}