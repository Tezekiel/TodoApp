package com.example.todo.appointments

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.appointments.model.Appointment
import com.example.todo.appointments.model.AppointmentState.PENDING
import com.example.todo.appointments.usecases.AppointmentValidationResult
import com.example.todo.appointments.usecases.DeleteAppointment
import com.example.todo.appointments.usecases.GetAppointments
import com.example.todo.appointments.usecases.SaveAppointment
import com.example.todo.appointments.usecases.ValidateAppointment
import com.example.todo.common.helpers.GetNow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class AppointmentsViewModel(
  private val getAppointments: GetAppointments,
  private val validateAppointment: ValidateAppointment,
  private val saveAppointment: SaveAppointment,
  private val deleteAppointment: DeleteAppointment,
  getNow: GetNow,
) : ViewModel() {

  val errors = MutableSharedFlow<String>()
  var isDarkMode: Boolean by mutableStateOf(true)
  var appointments: List<Appointment> by mutableStateOf(emptyList())

  private val defaultAppointment = Appointment(
    0,
    "Your appointment description goes here",
    "",
    getNow.getDate(),
    getNow.getTime(1),
    isEditing = true,
    state = PENDING
  )

  init {
    viewModelScope.launch { appointments = getAppointments() }
  }

  fun createEmptyAppointment() {
    if (appointments.any { it.isEditing }) {
      viewModelScope.launch { errors.emit("Please save or discard the current appointment") }
      return
    }
    appointments = appointments + defaultAppointment
  }

  fun validateAndSave(new: Appointment) {
    when (val res = validateAppointment(new)) {
      is AppointmentValidationResult.Failure -> viewModelScope.launch { errors.emit(res.message) }
      AppointmentValidationResult.Success -> save(new)
    }
  }

  private fun save(new: Appointment) {
    viewModelScope.launch {
      val res = saveAppointment(new)
      deleteCached(new.id)
      appointments = appointments + res
    }
  }

  private fun deleteCached(id: Long) {
    appointments = appointments.filter { it.id != id }
  }

  fun discardChanges(id: Long) {
    appointments = appointments.map {
      if (it.id == id) it.copy(isEditing = false) else it
    }
  }

  fun startEditing(id: Long) {
    appointments = appointments.map {
      if (it.id == id) it.copy(isEditing = true) else it
    }
  }

  fun delete(it: Long) {
    viewModelScope.launch {
      deleteCached(it)
      deleteAppointment(it)
    }
  }

}