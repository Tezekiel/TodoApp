package com.example.todo.appointments.usecases

import com.example.todo.appointments.dao.AppointmentDao
import com.example.todo.appointments.dao.model.toDomain
import com.example.todo.appointments.model.Appointment
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetAppointments(
  private val dao: AppointmentDao,
  private val ioDispatcher: CoroutineDispatcher
) {

  suspend operator fun invoke(): List<Appointment> {
    return withContext(ioDispatcher) {
      dao.getAll().map { it.toDomain() }
    }
  }
}