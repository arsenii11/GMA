package com.example.gma.TasksUtil

import java.util.*

class addTask (private val TaskRepository:TaskRepository){
    fun addTask(id:Int, name:String, priority:String, date: Date){
       TaskRepository.addTask(id,name,priority,date)
    }
}