package com.example.gma

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gma.databinding.ActivitySickLeaveBinding
import com.example.gma.databinding.ActivityVacationsBinding
import java.util.Calendar

class Vacations : AppCompatActivity() {

    private lateinit var binding: ActivityVacationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVacationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Return button
        binding.backbuttongr.setOnClickListener{
            val randomIntent = Intent(this, Documents::class.java)
            startActivity(randomIntent)
        }

        //Data picker
        val c = Calendar.getInstance()
        val year =c.get(Calendar.YEAR)
        val month =c.get(Calendar.MONTH)
        val data = c.get(Calendar.DAY_OF_MONTH)

        //button click to show DataPicker
        binding.editTextDate.setOnClickListener {
            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{ view, mYear, mMonth, mDay ->

                binding.editTextDate.text = (""+mDay+"/"+mMonth+"/"+mYear)
            },year, month,data)
            dpd.show()
        }
    }
}