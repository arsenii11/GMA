package com.example.gma.TasksDomain

class editTask(private val TaskRepository:TaskRepository) {
    fun editTask(TaskItem:TaskItem){
        return TaskRepository.editTask(TaskItem)
    }
}