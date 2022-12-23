package com.example.gma.TasksDomain

import java.util.*

interface TaskRepository {
    fun addTask(TaskItem:TaskItem)

    fun getTask(TaskId: Int):TaskItem

    fun editTask(TaskItem: TaskItem)

    fun deleteTask(TaskItem: TaskItem)

    fun getTasksList():List<TaskItem>
}