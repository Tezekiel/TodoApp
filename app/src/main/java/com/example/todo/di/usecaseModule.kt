package com.example.todo.di

import com.example.todo.appointments.usecases.GetAppointments
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val usecaseModule = module {
  factoryOf(::GetAppointments)
//    factory { GetAppointment(get()) }
//    factory { AddAppointment(get()) }
//    factory { UpdateAppointment(get()) }
//    factory { DeleteAppointment(get()) }
}