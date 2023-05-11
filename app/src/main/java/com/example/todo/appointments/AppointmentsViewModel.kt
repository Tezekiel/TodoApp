package com.example.todo.appointments

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.appointments.model.Appointment
import com.example.todo.appointments.usecases.GetAppointments
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class AppointmentsViewModel(
  private val getAppointments: GetAppointments
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

}