package com.example.eliteskills

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.eliteskills.database.TrainingDatabase
import com.example.eliteskills.database.TrainingEntity
import com.example.eliteskills.utils.NotificationUtils
import com.example.eliteskills.databinding.ActivityCreateTrainingBinding
import kotlinx.coroutines.launch

class CreateTrainingActivity : AppCompatActivity() {

    private lateinit var trainingDatabase: TrainingDatabase
    private lateinit var binding: ActivityCreateTrainingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateTrainingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        trainingDatabase = TrainingDatabase.getDatabase(this)

        binding.saveButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val date = binding.dateEditText.text.toString()
            val location = binding.locationEditText.text.toString()

            val training = TrainingEntity(name = name, date = date, location = location)

            lifecycleScope.launch {
                trainingDatabase.trainingDao().insert(training)

                NotificationUtils.sendNotification(this@CreateTrainingActivity, "Nowy Trening", "Dodano nowy trening w Twoim klubie!")

                finish()
            }
        }
    }
}
