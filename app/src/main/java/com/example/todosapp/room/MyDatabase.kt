package com.example.todosapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todosapp.data.entity.ToDos

@Database(entities = [ToDos::class], version = 1)
abstract class MyDatabase : RoomDatabase(){
    abstract fun getToDosDao() : ToDosDao
}