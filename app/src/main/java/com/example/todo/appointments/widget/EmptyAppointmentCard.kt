package com.example.todo.appointments.widget

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Paid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todo.R
import com.example.todo.appointments.model.Appointment
import com.example.todo.common.helpers.nowDate
import com.example.todo.common.helpers.nowTime
import com.example.todo.common.widgets.DatePicker
import com.example.todo.common.widgets.IconTextField
import com.example.todo.common.widgets.TimePicker

@Composable
fun EmptyAppointmentCard(
  modifier: Modifier = Modifier,
  onSave: (Appointment) -> Unit,
  onDiscard: () -> Unit,
) {
  val descriptionDefault = stringResource(R.string.your_appointment_description_goes_here)
  var date: String by remember { mutableStateOf(nowDate()) }
  var time: String by remember { mutableStateOf(nowTime()) }
  var description: String by remember { mutableStateOf(descriptionDefault) }
  var location: String by remember { mutableStateOf("") }

  Card(
    shape = RoundedCornerShape(8.dp),
    modifier = modifier
      .fillMaxWidth()
      .padding(16.dp, 8.dp)
      .border(1.dp, color = MaterialTheme.colorScheme.secondary),
    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
  ) {
    Column(
      modifier = Modifier.padding(8.dp),
      verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
      IconTextField(
        icon = Icons.Default.Edit,
        text = description,
      ) { description = it }
      DatePicker(value = date, onValueChange = { date = it }, isEditable = true)
      TimePicker(value = time, onValueChange = { time = it }, isEditable = true)
      LocationDropdown(isEditable = true) { location = it }
      Row(horizontalArrangement = Arrangement.SpaceBetween) {
        IconButton(onClick = { onSave(Appointment(-1, description, location, date, time)) }) {
          Icon(
            imageVector = Icons.Outlined.Check,
            contentDescription = stringResource(R.string.save_new_appointment_content_desc)
          )
        }
        IconButton(onClick = { onDiscard() }) {
          Icon(
            imageVector = Icons.Outlined.Delete,
            contentDescription = stringResource(R.string.cancel_new_appointment_content_desc)
          )
        }
      }
    }
  }
}
