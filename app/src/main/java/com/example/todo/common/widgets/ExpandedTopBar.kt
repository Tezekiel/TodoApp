package com.example.todo.common.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todo.R

val COLLAPSED_TOP_BAR_HEIGHT = 66.dp
val EXPANDED_TOP_BAR_HEIGHT = 132.dp

@Composable
fun ExpandedTopBar() {
  Box(
    modifier = Modifier
      .background(MaterialTheme.colorScheme.primary)
      .fillMaxWidth()
      .height(EXPANDED_TOP_BAR_HEIGHT - COLLAPSED_TOP_BAR_HEIGHT),
    contentAlignment = Alignment.CenterStart
  ) {
    Text(
      modifier = Modifier.padding(12.dp),
      text = stringResource(R.string.app_title),
      color = MaterialTheme.colorScheme.onPrimary,
      style = MaterialTheme.typography.headlineMedium,
    )
  }
}