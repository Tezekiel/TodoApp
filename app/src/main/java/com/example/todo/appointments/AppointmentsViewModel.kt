package com.example.todo.appointments

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.appointments.model.Appointment
import com.example.todo.appointments.usecases.AppointmentValidationResult
import com.example.todo.appointments.usecases.GetAppointments
import com.example.todo.appointments.usecases.SaveAppointment
import com.example.todo.appointments.usecases.ValidateAppointment
import com.example.todo.common.helpers.nowDate
import com.example.todo.common.helpers.nowTime
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class AppointmentsViewModel(
  private val getAppointments: GetAppointments,
  private val validateAppointment: ValidateAppointment,
  private val saveAppointment: SaveAppointment,
) : ViewModel() {

  val errors = MutableSharedFlow<String>()
  var isDarkMode: Boolean by mutableStateOf(true)
  var appointments: List<Appointment> by mutableStateOf(emptyList())

  init {
    viewModelScope.launch {
      getAppointments().fold(
        onSuccess = { appointments = it },
        onFailure = { errors.emit(it.message.toString()) }
      )
    }
  }

  fun createEmptyAppointment() {
    appointments = appointments + Appointment(-1, "", "", nowDate(), nowTime(1), isEditing = true)
  }

  fun validateAndSave(new: Appointment) {
    when (val res = validateAppointment(new)) {
      is AppointmentValidationResult.Failure -> errors.tryEmit(res.message)
      AppointmentValidationResult.Success -> save(new)
    }
  }

  private fun save(new: Appointment) {
    viewModelScope.launch {
      saveAppointment(new).fold(
        onSuccess = {
          delete(new.id)
          appointments = appointments + it
        },
        onFailure = { errors.emit(it.message.toString()) }
      )
      delete(-1)
    }
  }

  fun delete(id: Int) {
    appointments = appointments.toMutableList().filter { it.id != id }
  }

  fun discardChanges(id: Int) {
    appointments = appointments.map {
      if (it.id == id) it.copy(isEditing = false) else it
    }
  }

  fun startEditing(id: Int) {
    appointments = appointments.map {
      if (it.id == id) it.copy(isEditing = true) else it
    }
  }

}