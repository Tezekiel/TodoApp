package com.example.todo.appointments.usecases

import com.example.todo.appointments.model.Appointment

class SaveAppointment {

  suspend operator fun invoke(new: Appointment): Result<Appointment> {
    //todo return with id
    return Result.success(new)
  }
}