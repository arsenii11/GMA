package com.example.gma.TasksUtil

class getTask(private val TaskRepository:TaskRepository) {
    fun getTask(taskId: Int):TaskItem {
      return  TaskRepository.getTask(taskId)
    }
}