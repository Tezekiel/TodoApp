package com.example.todo.di

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val otherModule = module {
  single { Dispatchers.IO }
}