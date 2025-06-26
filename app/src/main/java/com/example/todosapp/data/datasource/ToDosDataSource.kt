package com.example.todosapp.data.datasource

import android.util.Log
import com.example.todosapp.data.entity.ToDos
import com.example.todosapp.room.ToDosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDataSource(var toDosDao: ToDosDao) {

    suspend fun save(name: String) {
        val newToDo = ToDos(0,name)
        toDosDao.save(newToDo)
    }

    suspend fun update(id: Int, name: String){
        toDosDao.update(id,name)
    }

    suspend fun delete(id:Int){
        val deletedToDo = ToDos(id,"")
        toDosDao.delete(deletedToDo)
    }

    suspend fun loadToDos() : List<ToDos> = withContext(Dispatchers.IO){

        return@withContext toDosDao.loadToDos()
    }

    suspend fun search(searchText: String) : List<ToDos> = withContext(Dispatchers.IO){
        return@withContext toDosDao.search(searchText)
    }
}