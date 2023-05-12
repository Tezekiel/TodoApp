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

  suspend operator fun invoke(new: Appointment): Result<Appointment> {
    return withContext(Dispatchers.IO) {
      val id = dao.insert(new.toEntity(true))
      Result.success(dao.getById(id).toDomain())
    }
  }
}