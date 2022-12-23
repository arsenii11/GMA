package com.example.gma.TasksDomain

import java.util.*

class addTask (private val TaskRepository:TaskRepository){
    fun addTask(TaskItem:TaskItem){
       TaskRepository.addTask(TaskItem)
    }
}