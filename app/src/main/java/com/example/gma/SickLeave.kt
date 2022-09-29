package com.example.gma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.gma.databinding.ActivitySickLeaveBinding
import com.example.gma.databinding.ActivityStudyBinding


class SickLeave : AppCompatActivity() {

  private lateinit var binding:ActivitySickLeaveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sick_leave)
        binding = ActivitySickLeaveBinding.inflate(layoutInflater)
        setContentView(binding.root)
      binding.backbuttongr.setOnClickListener{
            val randomIntent = Intent(this, Documents::class.java)
            startActivity(randomIntent)
          finish()
        }
    }
}