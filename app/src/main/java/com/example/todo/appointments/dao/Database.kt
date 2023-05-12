package com.example.todo.appointments.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo.appointments.dao.model.AppointmentEntity

@Database(entities = [AppointmentEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun appointmentDao(): AppointmentDao
}