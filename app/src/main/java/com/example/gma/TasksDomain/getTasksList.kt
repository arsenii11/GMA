package com.example.gma.TasksDomain

class getTasksList(private val TaskRepository: TaskRepository) {
    fun getTasksList(): List<TaskItem> {
        return TaskRepository.getTasksList()
    }
}