package com.example.todo.appointments.dao.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todo.appointments.model.Appointment
import com.example.todo.appointments.model.AppointmentState

@Entity
data class AppointmentEntity(
  @PrimaryKey(autoGenerate = true) val id: Long,
  @ColumnInfo(name = "description") val description: String,
  @ColumnInfo(name = "location") val location: String,
  @ColumnInfo(name = "date") val date: String,
  @ColumnInfo(name = "time") val time: String,
)

fun AppointmentEntity.toDomain() = Appointment(
  id = id,
  description = description,
  location = location,
  date = date,
  time = time,
  state = AppointmentState.DONE
)

fun Appointment.toEntity() = AppointmentEntity(
  id = id,
  description = description,
  location = location,
  date = date,
  time = time,
)
