package com.example.todo.appointments.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todo.appointments.dao.model.AppointmentEntity

@Dao
interface AppointmentDao {
  @Query("SELECT * FROM AppointmentEntity")
  suspend fun getAll(): List<AppointmentEntity>

  @Query("SELECT * FROM AppointmentEntity WHERE id IN (:id)")
  fun getById(id: Long): AppointmentEntity

  @Update
  fun updateAppointment(appointment: AppointmentEntity)

  @Query("DELETE FROM AppointmentEntity WHERE id IN (:id)")
  suspend fun delete(id: Long)

  @Insert
  suspend fun insert(appointment: AppointmentEntity): Long
}