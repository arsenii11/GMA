package com.example.gma.TasksDomain

class deleteTask (private val TaskRepository:TaskRepository){
    fun deleteTask(TaskItem:TaskItem) {
        TaskRepository.deleteTask(TaskItem)
    }
}