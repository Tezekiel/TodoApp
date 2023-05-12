package com.example.todo.appointments.widget

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todo.appointments.AppointmentsViewModel
import com.example.todo.common.widgets.ExpandedTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppointmentsScreen(
  listState: LazyListState,
  viewModel: AppointmentsViewModel = koinViewModel()
) {
  LazyColumn(
    state = listState,
    modifier = Modifier.fillMaxSize()
  ) {
    item { ExpandedTopBar() }
    items(viewModel.appointments, key = { it.id }) { appointment ->
      AppointmentCard(
        appointment = appointment,
        isEditing = appointment.isEditing,
        onSave = { viewModel.validateAndSave(it) },
        onDelete = { viewModel.delete(it) },
        onDiscard = { viewModel.discardChanges(it) },
        onStartEditing = { viewModel.startEditing(it) },
      )
    }
    item {
      AddNewAppointmentButton {
        viewModel.createEmptyAppointment()
      }
    }
  }
}
