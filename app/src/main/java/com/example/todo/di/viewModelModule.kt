package com.example.todo.di

import com.example.todo.appointments.AppointmentsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
  viewModelOf(::AppointmentsViewModel)
}