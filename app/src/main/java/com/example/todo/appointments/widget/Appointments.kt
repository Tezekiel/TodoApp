package com.example.todo.appointments.widget

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todo.common.widgets.ExpandedTopBar

@Composable
fun Appointments(listState: LazyListState) {
  LazyColumn(
    state = listState,
    modifier = Modifier.fillMaxSize()
  ) {
    item { ExpandedTopBar() }
    items(10) { AppointmentCard() }
  }
}