package com.example.todo.appointments.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Nightlight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.R

@Composable
fun ThemeIcon(isDarkMode: Boolean) {
  val icon = if (isDarkMode) Icons.Filled.Lightbulb else Icons.Filled.Nightlight
  Box(modifier = Modifier
    .clip(CircleShape)
    .background(MaterialTheme.colorScheme.primary)
    .padding(12.dp)
  ){
    Icon(
      tint = Color.White,
      imageVector = icon,
      contentDescription = stringResource(R.string.change_theme_content_desc)
    )
  }
}

@Preview
@Composable
fun ThemeIconPreview() {
  ThemeIcon(isDarkMode = true)
}