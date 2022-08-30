package com.example.gma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.gma.databinding.ActivityDocumentsBinding
import com.example.gma.databinding.ActivityMainBinding


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



    }
}