package com.example.gma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gma.databinding.ActivityGroupsBinding
import com.example.gma.databinding.ActivityStudyBinding

class Study : AppCompatActivity() {

    private lateinit var binding: ActivityStudyBinding

            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                binding = ActivityStudyBinding.inflate(layoutInflater)
                setContentView(binding.root)
                binding.backbuttongr.setOnClickListener{
                    val randomIntent = Intent(this, MainActivity::class.java)
                    startActivity(randomIntent)
                }
    }
}