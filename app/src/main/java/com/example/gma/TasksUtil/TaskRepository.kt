package com.example.gma.TasksUtil

import java.util.*

interface TaskRepository {
    fun addTask(id:Int, name:String, priority:String, date: Date)

    fun getTask(taskId: Int):TaskItem

    fun editTask(TaskId:Int):TaskItem

    fun deleteTask(taskId: Int)
}