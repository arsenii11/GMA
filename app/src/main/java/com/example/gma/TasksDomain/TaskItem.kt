package com.example.gma.TasksDomain

import java.util.Date

data class TaskItem(

    val name:String,
    val priority:String,
    val date:Date,
    var id:Int = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}
