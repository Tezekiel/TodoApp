package com.example.todo.appointments.model

data class Appointment(
  val id: Int,
  val description: String,
  val location: String,
  val date: String,
  val time: String,
)
