package com.example.todo.appointments.model

data class Appointment(
  val id: Long,
  val description: String,
  val location: String,
  val date: String,
  val time: String,
  val state: AppointmentState,
  val isEditing: Boolean = false,
)

enum class AppointmentState{
  PENDING, DONE
}
