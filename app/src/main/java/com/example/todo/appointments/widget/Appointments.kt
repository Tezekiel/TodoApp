package com.example.todo.appointments.widget

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todo.R
import com.example.todo.appointments.model.Appointment
import com.example.todo.common.widgets.ExpandedTopBar
import com.example.todo.common.widgets.IconText

@Composable
fun Appointments(
  listState: LazyListState,
  appointments: List<Appointment>
) {
  LazyColumn(
    state = listState,
    modifier = Modifier.fillMaxSize()
  ) {
    item { ExpandedTopBar() }
    appointments.forEach { appointment ->
      item { AppointmentCard(appointment = appointment) }
    }
    item {
      Button(
        modifier = Modifier.padding(16.dp),
        onClick = { /*TODO*/ }
      ) {
        IconText(
          icon = Icons.Filled.Add,
          text = stringResource(R.string.add_new_appointment)
        )
      }
    }
  }
}