package com.example.eliteskills

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCreateTraining: MaterialButton = findViewById(R.id.buttonCreateTraining)
        val buttonPlayerAttendance: MaterialButton = findViewById(R.id.buttonPlayerAttendance)
        val buttonTrainingList: MaterialButton = findViewById(R.id.buttonTrainingList)


        buttonCreateTraining.setOnClickListener {
            val intent = Intent(this, CreateTrainingActivity::class.java)
            startActivity(intent)
        }

        buttonPlayerAttendance.setOnClickListener {
            val intent = Intent(this, PlayerAttendanceActivity::class.java)
            startActivity(intent)
        }

        buttonTrainingList.setOnClickListener {
            val intent = Intent(this, TrainingListActivity::class.java)
            startActivity(intent)
        }
    }
}
