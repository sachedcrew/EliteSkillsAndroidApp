package com.example.eliteskills.database

import androidx.room.*

@Dao
interface TrainingDao {
    @Insert
    suspend fun insert(training: TrainingEntity)

    @Update
    suspend fun update(training: TrainingEntity)

    @Delete
    suspend fun delete(training: TrainingEntity)

    @Query("SELECT * FROM trainings")
    suspend fun getAllTrainings(): List<TrainingEntity>

    @Query("SELECT * FROM trainings WHERE id = :id")
    suspend fun getTrainingById(id: Long): TrainingEntity?
}
