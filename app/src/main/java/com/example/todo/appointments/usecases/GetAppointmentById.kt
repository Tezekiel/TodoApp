package com.example.todo.appointments.usecases

import com.example.todo.appointments.dao.AppointmentDao
import com.example.todo.appointments.dao.model.toDomain
import com.example.todo.appointments.model.Appointment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAppointmentById(
  private val dao: AppointmentDao
) {

  suspend operator fun invoke(appointment: Appointment): Result<Appointment> {
    return withContext(Dispatchers.IO) {
      Result.success(dao.getById(appointment.id).toDomain())
    }
  }
}