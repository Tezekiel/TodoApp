package com.example.todo.appointments.usecases

import com.example.todo.appointments.model.Appointment
import com.example.todo.appointments.usecases.AppointmentValidationResult.Failure

class ValidateAppointment {

  operator fun invoke(new: Appointment): AppointmentValidationResult {
    with(new) {
      if (description.isBlank()) return Failure("Description cannot be blank")
      if (location.isBlank()) return Failure("Location cannot be blank")
      if (date.isBlank()) return Failure("Date cannot be blank")
      if (time.isBlank()) return Failure("Time cannot be blank")
      return AppointmentValidationResult.Success
    }
  }
}

sealed class AppointmentValidationResult {
  object Success : AppointmentValidationResult()
  data class Failure(val message: String) : AppointmentValidationResult()
}

