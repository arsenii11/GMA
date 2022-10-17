package com.example.gma.Doc_screens

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gma.Documents
import com.example.gma.R
import com.example.gma.Result_ok_l
import com.example.gma.databinding.ActivitySickLeaveBinding
import java.util.Calendar


class SickLeave : AppCompatActivity() {

  private lateinit var binding:ActivitySickLeaveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySickLeaveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Return button
      binding.backbuttongr.setOnClickListener{
            val randomIntent = Intent(this, Documents::class.java)
            startActivity(randomIntent)
          overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
          finish()
        }

        //Data picker
        val c = Calendar.getInstance()
        val year =c.get(Calendar.YEAR)
        val month =c.get(Calendar.MONTH)
        val data = c.get(Calendar.DAY_OF_MONTH)

        //button click to show DataPicker
        binding.editTextDate.setOnClickListener {
            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view, mYear, mMonth, mDay ->

                binding.editTextDate.text = (""+mDay+"/"+mMonth+"/"+mYear)
            },year, month,data)
            dpd.show()
        }

        binding.sendBt.setOnClickListener {
            val resultIntent = Intent(this, Result_ok_l::class.java)
            startActivity(resultIntent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        finish()
        }
    }
}