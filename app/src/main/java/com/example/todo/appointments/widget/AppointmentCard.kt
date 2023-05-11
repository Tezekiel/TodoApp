package com.example.todo.appointments.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.R
import com.example.todo.appointments.model.Appointment
import com.example.todo.common.helpers.nowDate
import com.example.todo.common.helpers.nowTime
import com.example.todo.common.widgets.DatePicker
import com.example.todo.common.widgets.IconText
import com.example.todo.common.widgets.IconTextField
import com.example.todo.common.widgets.TimePicker

@Composable
fun AppointmentCard(
  modifier: Modifier = Modifier,
  appointment: Appointment,
  isEditable: Boolean = false
) {
  var date: String by remember { mutableStateOf(nowDate()) }
  var time: String by remember { mutableStateOf(nowTime()) }
  var newCard: Appointment? by remember { mutableStateOf(null) }

  Card(
    shape = RoundedCornerShape(8.dp),
    modifier = modifier
      .fillMaxWidth()
      .padding(16.dp, 8.dp),
    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
  ) {
    Column(
      modifier = Modifier.padding(8.dp),
      verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
      if (isEditable) {
        IconText(
          icon = Icons.Default.Edit,
          text = stringResource(R.string.your_appointment_description_goes_here),
        )
      } else {
        IconTextField(
          icon = Icons.Default.Edit,
          text = newCard?.description ?: stringResource(R.string.your_appointment_description_goes_here),
        ){
          newCard?.copy(description = it)
        }
      }
      DatePicker(value = date, onValueChange = { date = it }, isEditable = isEditable)
      TimePicker(value = time, onValueChange = { time = it }, isEditable = isEditable)
      LocationDropdown(isEditable = isEditable)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun AppointmentRowPreview() {
  AppointmentCard(
    appointment = Appointment(
      22,
      "Doctors appointment",
      "123 Main St",
      "2021-09-01",
      "12:00"
    ),
    isEditable = false
  )
}