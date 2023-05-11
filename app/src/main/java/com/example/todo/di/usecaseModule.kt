package com.example.todo.di

import com.example.todo.appointments.usecases.GetAppointments
import com.example.todo.appointments.usecases.SaveAppointment
import com.example.todo.appointments.usecases.ValidateAppointment
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val usecaseModule = module {
  factoryOf(::GetAppointments)
  factoryOf(::SaveAppointment)
  factoryOf(::ValidateAppointment)
//    factory { UpdateAppointment(get()) }
//    factory { DeleteAppointment(get()) }
}