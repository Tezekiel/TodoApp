package com.example.todo.common.widgets

import android.app.TimePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun TimePicker(
  value: String,
  onValueChange: (String) -> Unit,
  pattern: String = "HH:mm",
  is24HourView: Boolean = true,
  isEditable: Boolean = false,
) {
  val formatter = DateTimeFormatter.ofPattern(pattern)
  val time = if (value.isNotBlank()) LocalTime.parse(value, formatter) else LocalTime.now()
  val dialog = TimePickerDialog(
    LocalContext.current,
    { _, hour, minute -> onValueChange(LocalTime.of(hour, minute).toString()) },
    time.hour,
    time.minute,
    is24HourView,
  )

  IconText(
    modifier = if (isEditable) {Modifier.clickable { dialog.show() }} else Modifier,
    icon = Icons.Default.Timer,
    contentDesc = "Date picker",
    text = "Time of appointment: $value",
  )
}