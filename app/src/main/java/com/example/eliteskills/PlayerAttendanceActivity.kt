package com.example.eliteskills

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.eliteskills.databinding.ActivityPlayerAttendanceBinding

class PlayerAttendanceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayerAttendanceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerAttendanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.attendButton.setOnClickListener {
            markAttendance()
        }
    }

    private fun markAttendance() {
        binding.attendButton.isEnabled = false
        binding.attendButton.text = "Obecność zaznaczona ✅"
    }
}
