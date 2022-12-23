package com.example.gma.TasksDomain

class getTask(private val TaskRepository:TaskRepository) {
    fun getTask(taskId: Int):TaskItem {
      return  TaskRepository.getTask(taskId)
    }
}