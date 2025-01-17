package com.example.eliteskills

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eliteskills.database.TrainingDatabase
import com.example.eliteskills.database.TrainingEntity
import com.example.eliteskills.databinding.ItemTrainingBinding
import kotlinx.coroutines.launch

class TrainingListActivity : AppCompatActivity() {

    private lateinit var binding: ItemTrainingBinding
    private lateinit var trainingDatabase: TrainingDatabase
    private lateinit var adapter: TrainingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemTrainingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        trainingDatabase = TrainingDatabase.getDatabase(this)
        adapter = TrainingAdapter { training -> openTrainingDetails(training) }


        loadTrainings()
    }

    private fun loadTrainings() {
        lifecycleScope.launch {
            val trainings = trainingDatabase.trainingDao().getAllTrainings()
            adapter.submitList(trainings)
        }
    }

    private fun openTrainingDetails(training: TrainingEntity) {
        val intent = Intent(this, PlayerAttendanceActivity::class.java).apply {
            putExtra("trainingId", training.id)
        }
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        loadTrainings()
    }
}
