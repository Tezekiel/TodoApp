package com.example.todo.appointments.widget

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todo.R
import com.example.todo.common.widgets.IconText

@Composable
fun AddNewAppointmentButton(
  onAdd: () -> Unit
) {
  Button(
    modifier = Modifier.padding(16.dp),
    onClick = { onAdd() }
  ) {
    IconText(
      icon = Icons.Filled.Add,
      text = stringResource(R.string.add_new_appointment)
    )
  }
}