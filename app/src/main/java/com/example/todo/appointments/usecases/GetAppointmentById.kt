package com.example.todo.appointments.usecases

import com.example.todo.appointments.dao.AppointmentDao
import com.example.todo.appointments.dao.model.toDomain
import com.example.todo.appointments.model.Appointment
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetAppointmentById(
  private val dao: AppointmentDao,
  private val ioDispatcher: CoroutineDispatcher
) {

  suspend operator fun invoke(appointment: Appointment): Appointment {
    return withContext(ioDispatcher) {
      dao.getById(appointment.id).toDomain()
    }
  }
}