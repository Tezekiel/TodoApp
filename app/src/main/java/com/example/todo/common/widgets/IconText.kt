package com.example.todo.common.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IconText(
  modifier: Modifier = Modifier,
  icon: ImageVector = Icons.Outlined.DateRange,
  contentDesc: String = "Calendar Icon",
  text: String = "10.11.2022."
) {
  Row(
    modifier = modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Icon(
      modifier = Modifier
        .padding(0.dp, 0.dp, 8.dp, 0.dp)
        .size(14.dp),
      imageVector = icon,
      contentDescription = contentDesc,
    )
    Text(
      text = text,
      style = MaterialTheme.typography.labelMedium
    )
  }
}