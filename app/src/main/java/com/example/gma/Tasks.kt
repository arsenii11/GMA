package com.example.gma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramotion.foldingcell.FoldingCell

class Tasks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks_list)



        // get our folding cell
       val fc:FoldingCell=  findViewById(R.id.folding_cell)

        // attach click listener to folding cell
        fc.setOnClickListener{

                fc.toggle(false)

        }
    }
}