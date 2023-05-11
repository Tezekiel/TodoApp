package com.example.todo.common.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todo.R

@Composable
fun CollapsedTopBar(
  modifier: Modifier = Modifier,
  isCollapsed: Boolean
) {
  val color: Color by animateColorAsState(
    if (isCollapsed) {
      MaterialTheme.colorScheme.background
    } else {
      MaterialTheme.colorScheme.primary
    }
  )
  Box(
    modifier = modifier
      .background(color)
      .fillMaxWidth()
      .height(COLLAPSED_TOP_BAR_HEIGHT)
      .padding(16.dp),
    contentAlignment = Alignment.BottomStart
  ) {
    AnimatedVisibility(visible = isCollapsed) {
      Text(text = stringResource(R.string.app_title), style = MaterialTheme.typography.headlineSmall)
    }
  }
}