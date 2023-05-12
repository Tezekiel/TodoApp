package com.example.todo.appointments.usecases

import com.example.todo.appointments.dao.AppointmentDao
import com.example.todo.appointments.dao.model.toDomain
import com.example.todo.appointments.model.Appointment
import com.example.todo.appointments.model.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaveAppointment(
  private val dao: AppointmentDao
) {

  suspend operator fun invoke(new: Appointment): Appointment {
    return withContext(Dispatchers.IO) {
      val id = if (new.id < 0) {
        dao.insert(new.toEntity(true))
      } else {
        dao.updateAppointment(new.toEntity())
        new.id
      }
      dao.getById(id).toDomain()
    }
  }
}