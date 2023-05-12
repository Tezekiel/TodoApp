package com.example.todo.common.helpers

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GetNow {

  fun getDate(): String {
    return LocalDateTime.now()
      .toLocalDate()
      .toString()
  }

  fun getTime(addHours: Long = 1L): String {
    return LocalDateTime.now()
      .toLocalTime()
      .plusHours(addHours)
      .format(DateTimeFormatter.ofPattern("HH:mm"))
      .toString()
  }
}