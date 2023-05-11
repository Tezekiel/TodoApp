package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.ui.theme.TodoTheme
import com.example.todo.widget.AppointmentRow

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // todo move somewhere else
    val isDark = true
    setContent {
      TodoTheme(
        darkTheme = isDark
      ) {
        Surface(
          modifier = Modifier
            .fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          LazyColumn(
            modifier = Modifier
              .fillMaxSize()
              .padding(16.dp)
          ) {
            items(10) {
              AppointmentRow()
            }
          }
        }
      }
    }
  }
}
