package com.example.todo.appointments


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.todo.common.theme.TodoTheme
import com.example.todo.appointments.widget.Appointments
import com.example.todo.common.widgets.CollapsedTopBar
import org.koin.androidx.viewmodel.ext.android.viewModel

@OptIn(ExperimentalMaterial3Api::class)
class AppointmentsActivity : ComponentActivity() {
  private val viewModel: AppointmentsViewModel by viewModel()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TodoTheme(darkTheme = viewModel.isDarkMode) {
        val listState = rememberLazyListState()
        val isCollapsed: Boolean by remember {
          derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }
        Scaffold(
          topBar = { CollapsedTopBar(isCollapsed = isCollapsed) })
        { padding ->
          Surface(
            modifier = Modifier
              .fillMaxSize()
              .padding(padding),
            color = MaterialTheme.colorScheme.background
          ) {
            Appointments(listState = listState, appointments = viewModel.appointments)
          }
        }
      }
    }
  }
}
