package com.example.todo.appointments.usecases

import com.example.todo.appointments.model.Appointment

class GetAppointments {

  suspend operator fun invoke(): Result<List<Appointment>> {
    return Result.success(
      listOf(
        Appointment("Dentist", "San Diego", "2020-01-01", "12:00"),
        Appointment("Doctor", "St. George", "2020-01-02", "13:00"),
        Appointment("Doctor", "dasfs. George", "2020-01-02", "13:00"),
        Appointment("Docfasfastor", "St. George", "2020-01-02", "13:00"),
      )
    )
  }
}