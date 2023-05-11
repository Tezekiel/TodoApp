package com.example.todo.common.helpers

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun nowDate() =
  LocalDateTime.now()
    .toLocalDate()
    .toString()

fun nowTime(addHours: Long = 1L) =
  LocalDateTime.now()
    .toLocalTime()
    .plusHours(addHours)
    .format(DateTimeFormatter.ofPattern("HH:mm"))
    .toString()
