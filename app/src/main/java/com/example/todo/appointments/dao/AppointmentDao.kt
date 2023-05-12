package com.example.todo.appointments.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todo.appointments.dao.model.AppointmentEntity

@Dao
interface AppointmentDao {
  @Query("SELECT * FROM AppointmentEntity")
  suspend fun getAll(): List<AppointmentEntity>

  @Delete
  suspend fun delete(appointment: AppointmentEntity)

  @Insert
  suspend fun insert(appointment: AppointmentEntity): Long
}