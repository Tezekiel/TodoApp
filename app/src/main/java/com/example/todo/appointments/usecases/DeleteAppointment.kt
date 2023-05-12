package com.example.todo.appointments.usecases

import com.example.todo.appointments.dao.AppointmentDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DeleteAppointment(
  private val dao: AppointmentDao,
  private val ioDispatcher: CoroutineDispatcher
) {

  suspend operator fun invoke(id: Long) {
    withContext(ioDispatcher) { dao.delete(id) }
  }
}