package com.example.todo.di

import com.example.todo.appointments.usecases.*
import com.example.todo.appointments.usecases.ValidateAppointment
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val usecaseModule = module {
  factoryOf(::GetAppointments)
  factoryOf(::SaveAppointment)
  factoryOf(::ValidateAppointment)
  factoryOf(::GetAppointmentById)
  factoryOf(::DeleteAppointment)
  factoryOf(::UpdateAppointment)
}