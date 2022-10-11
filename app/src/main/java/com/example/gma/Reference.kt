package com.example.gma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gma.databinding.ActivityReferenceBinding
import com.example.gma.databinding.ActivitySickLeaveBinding

class Reference : AppCompatActivity() {

    private lateinit var binding: ActivityReferenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Return button
        binding.backbuttongr.setOnClickListener{
            val randomIntent = Intent(this, Documents::class.java)
            startActivity(randomIntent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            finish()
        }
        binding.sendBt.setOnClickListener {
            val resultIntent = Intent(this, Result_ok_l::class.java)
            startActivity(resultIntent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()
        }
    }
}