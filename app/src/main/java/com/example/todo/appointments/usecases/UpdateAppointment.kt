package com.example.todo.appointments.usecases

import com.example.todo.appointments.dao.AppointmentDao
import com.example.todo.appointments.dao.model.toEntity
import com.example.todo.appointments.model.Appointment
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class UpdateAppointment(
  private val dao: AppointmentDao,
  private val ioDispatcher: CoroutineDispatcher
) {

  suspend operator fun invoke(appointment: Appointment) {
    withContext(ioDispatcher) {
      dao.updateAppointment(appointment.toEntity())
    }
  }
}