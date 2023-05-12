package com.example.todo.appointments.usecases

import com.example.todo.appointments.model.Appointment
import com.example.todo.appointments.usecases.AppointmentValidationResult.Failure

class ValidateAppointment {

  operator fun invoke(new: Appointment): AppointmentValidationResult {
    with(new) {
      return when {
        description.isBlank() -> Failure("Description cannot be blank")
        location.isBlank() -> Failure("Location cannot be blank")
        date.isBlank() -> Failure("Date cannot be blank")
        time.isBlank() -> Failure("Time cannot be blank")
        else -> AppointmentValidationResult.Success
      }
    }
  }
}

sealed class AppointmentValidationResult {
  object Success : AppointmentValidationResult()
  data class Failure(val message: String) : AppointmentValidationResult()
}

