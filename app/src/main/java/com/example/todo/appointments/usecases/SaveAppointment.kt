package com.example.todo.appointments.usecases

import com.example.todo.appointments.dao.AppointmentDao
import com.example.todo.appointments.dao.model.toDomain
import com.example.todo.appointments.model.Appointment
import com.example.todo.appointments.model.toEntity

class SaveAppointment(
  private val dao: AppointmentDao
) {

  suspend operator fun invoke(new: Appointment): Result<Long> {
    return Result.success(dao.insert(new.toEntity()))
  }
}