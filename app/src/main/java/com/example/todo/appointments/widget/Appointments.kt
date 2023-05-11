package com.example.todo.appointments.widget

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
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
    viewModel.appointments.forEach { appointment ->
      item { AppointmentCard(appointment = appointment, isEditable = false) }
    }
    viewModel.emptyAppointment?.let {
      item {
        EmptyAppointmentCard(
          onSave = { viewModel.saveAppointment(it) },
          onDiscard = { viewModel.discardNewAppointment() },
        )
      }
    }
    item {
      AddNewAppointmentButton {
        viewModel.createEmptyAppointment()
      }
    }
  }
}
