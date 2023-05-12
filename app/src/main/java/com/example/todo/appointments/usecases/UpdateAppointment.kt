package com.example.todo.appointments.usecases

import com.example.todo.appointments.dao.AppointmentDao
import com.example.todo.appointments.dao.model.toDomain
import com.example.todo.appointments.model.Appointment
import com.example.todo.appointments.model.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateAppointment(
  private val dao: AppointmentDao
) {

  suspend operator fun invoke(appointment: Appointment) {
    withContext(Dispatchers.IO) {
      dao.updateAppointment(appointment.toEntity())
    }
  }
}