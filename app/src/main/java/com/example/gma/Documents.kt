package com.example.gma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.gma.databinding.ActivityDocumentsBinding


class Documents : AppCompatActivity() {

    private lateinit var binding: ActivityDocumentsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDocumentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backbutton.setOnClickListener{
            val randomIntent = Intent(this, MainActivity::class.java)
            startActivity(randomIntent)
        }

        binding.sickleavesBlock.setOnClickListener{
            val randomIntent = Intent(this, SickLeave::class.java)
            startActivity(randomIntent)
            finish()
        }



    }
}