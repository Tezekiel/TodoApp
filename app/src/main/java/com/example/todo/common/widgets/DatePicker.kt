package com.example.todo.common.widgets

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.EditCalendar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DatePicker(
  value: String,
  onValueChange: (String) -> Unit = {},
  pattern: String = "yyyy-MM-dd",
) {
  val formatter = DateTimeFormatter.ofPattern(pattern)
  val date = if (value.isNotBlank()) LocalDate.parse(value, formatter) else LocalDate.now()
  val dialog = DatePickerDialog(
    LocalContext.current,
    { _, year, month, dayOfMonth ->
      onValueChange(LocalDate.of(year, month + 1, dayOfMonth).toString())
    },
    date.year,
    date.monthValue - 1,
    date.dayOfMonth,
  )

  IconText(
    modifier = Modifier.clickable { dialog.show() },
    icon = Icons.Outlined.EditCalendar,
    contentDesc = "Date picker",
    text = "Date of appointment: $value",
  )
}
