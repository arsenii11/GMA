package com.example.gma.TasksUtil

class deleteTask (private val TaskRepository:TaskRepository){
    fun deleteTask(taskId: Int) {
        TaskRepository.deleteTask(taskId)
    }
}