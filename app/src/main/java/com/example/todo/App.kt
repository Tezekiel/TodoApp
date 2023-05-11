package com.example.todo

import android.app.Application
import com.example.todo.di.modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidLogger()
      androidContext(this@App)
      modules(modules)
    }
  }
}