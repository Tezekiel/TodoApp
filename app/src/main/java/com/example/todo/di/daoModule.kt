package com.example.todo.di

import androidx.room.Room
import com.example.todo.appointments.dao.AppDatabase
import com.example.todo.appointments.dao.AppointmentDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val daoModule = module {
  single {
    Room.databaseBuilder(
      androidContext(),
      AppDatabase::class.java,
      "database-name"
    ).build()
  }

  single { get<AppDatabase>().appointmentDao() }
}