package com.example.gma.TasksData

import com.example.gma.TasksDomain.TaskItem
import com.example.gma.TasksDomain.TaskRepository
import java.util.*

object TasksRepositoryImpl : TaskRepository {

    private val tasksList = mutableListOf<TaskItem>()

    private var autoIncrementId = 0

    override fun addTask(taskItem: TaskItem) {
        if (taskItem.id == TaskItem.UNDEFINED_ID) {
            taskItem.id = autoIncrementId++
        }
        tasksList.add(taskItem)
    }

    override fun getTask(TaskId: Int): TaskItem {
        return tasksList.find {
            it.id == TaskId
        } ?: throw RuntimeException("Element with id $TaskId not found")
    }

    override fun editTask(taskItem: TaskItem) {
        val oldElement = getTask(taskItem.id)
        tasksList.remove(oldElement)
        addTask(taskItem)
    }

    override fun deleteTask(taskItem: TaskItem) {
        tasksList.remove(taskItem)
    }

    override fun getTasksList(): List<TaskItem> {
        return tasksList.toList()
    }


}