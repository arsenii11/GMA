package com.example.gma.TasksUtil

class editTask(private val TaskRepository:TaskRepository) {
    fun editTask(TaskId:Int):TaskItem{
        return TaskRepository.editTask(TaskId)
    }
}