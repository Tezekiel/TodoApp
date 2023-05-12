package com.example.todo.appointments.usecases

import com.example.todo.appointments.dao.AppointmentDao
import com.example.todo.appointments.dao.model.toDomain
import com.example.todo.appointments.dao.model.toEntity
import com.example.todo.appointments.model.Appointment
import com.example.todo.appointments.model.AppointmentState.DONE
import com.example.todo.appointments.model.AppointmentState.PENDING
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SaveAppointment(
  private val dao: AppointmentDao,
  private val ioDispatcher: CoroutineDispatcher
) {

  suspend operator fun invoke(new: Appointment): Appointment {
    return withContext(ioDispatcher) {
      when (new.state) {
        PENDING -> {
          dao.getById((dao.insert(new.toEntity()))).toDomain()
        }
        DONE -> {
          dao.updateAppointment(new.toEntity())
          dao.getById(new.id).toDomain()
        }
      }
    }
  }
}