package com.example.todo.appointments.model

import com.example.todo.appointments.dao.model.AppointmentEntity

data class Appointment(
  val id: Long,
  val description: String,
  val location: String,
  val date: String,
  val time: String,
  val isEditing: Boolean = false
)

fun Appointment.toEntity(resetId: Boolean = false) = AppointmentEntity(
  id = if (resetId) 0 else id,
  description = description,
  location = location,
  date = date,
  time = time,
)
