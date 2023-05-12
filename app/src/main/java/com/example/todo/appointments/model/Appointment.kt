package com.example.todo.appointments.model

import com.example.todo.appointments.dao.model.AppointmentEntity

data class Appointment(
  val id: Int,
  val description: String,
  val location: String,
  val date: String,
  val time: String,
  val isEditing: Boolean = false
)

fun Appointment.toEntity() = AppointmentEntity(
  id = 0,
  description = description,
  location = location,
  date = date,
  time = time,
)
