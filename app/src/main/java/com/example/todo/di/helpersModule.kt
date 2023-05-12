package com.example.todo.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.example.todo.common.helpers.GetNow

val helpersModule = module {
  factoryOf(::GetNow)
}