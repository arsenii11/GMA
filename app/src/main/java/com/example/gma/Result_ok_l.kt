package com.example.gma

import android.content.Intent
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.isVisible
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.gma.databinding.ActivityFileSavedBinding


class Result_ok_l : AppCompatActivity() {






    private lateinit var binding: ActivityFileSavedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFileSavedBinding.inflate(layoutInflater)
        setContentView(binding.root)


        object : CountDownTimer(1100, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                binding.greenCircle.isVisible = true
                val avd: AnimatedVectorDrawable = binding.done.drawable as AnimatedVectorDrawable
                avd.start()
            }



            override fun onFinish() {
                binding.greenCircle.isVisible = false
               returnToMain()
            }
        }.start()


    }

    fun returnToMain(){
        val resultIntent = Intent(this, MainActivity::class.java)
        startActivity(resultIntent)
        finish()
    }


}