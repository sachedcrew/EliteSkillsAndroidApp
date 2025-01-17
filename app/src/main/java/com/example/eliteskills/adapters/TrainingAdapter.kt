package com.example.eliteskills

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eliteskills.database.TrainingEntity
import com.example.eliteskills.databinding.ItemTrainingBinding

class TrainingAdapter(private val onItemClick: (TrainingEntity) -> Unit) :
    RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>() {

    private var trainingList: List<TrainingEntity> = emptyList()

    fun submitList(list: List<TrainingEntity>) {
        trainingList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val binding = ItemTrainingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrainingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        holder.bind(trainingList[position])
    }

    override fun getItemCount() = trainingList.size

    inner class TrainingViewHolder(private val binding: ItemTrainingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(training: TrainingEntity) {
            binding.trainingName.text = training.name
            binding.trainingDate.text = training.date
            binding.trainingLocation.text = training.location

            binding.root.setOnClickListener {
                onItemClick(training)
            }
        }
    }
}
