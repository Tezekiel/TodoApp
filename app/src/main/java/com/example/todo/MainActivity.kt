@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.todo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.todo.ui.theme.TodoTheme
import com.example.todo.widget.AppointmentCard
import com.example.todo.widget.CollapsedTopBar
import com.example.todo.widget.ExpandedTopBar

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // todo move somewhere else
    val isDark = true
    setContent {
      TodoTheme(darkTheme = isDark) {
        val listState = rememberLazyListState()
        val isCollapsed: Boolean by remember {
          derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }
        Scaffold(
          topBar = { CollapsedTopBar(isCollapsed = isCollapsed) })
        { padding ->
          Surface(
            modifier = Modifier.fillMaxSize().padding(padding),
            color = MaterialTheme.colorScheme.background
          ) {
            LazyColumn(
              state = listState,
              modifier = Modifier.fillMaxSize()
            ) {
              item { ExpandedTopBar() }
              items(10) { AppointmentCard() }
            }
          }
        }
      }
    }
  }
}
