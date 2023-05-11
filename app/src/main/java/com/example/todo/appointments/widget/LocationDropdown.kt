package com.example.todo.appointments.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.todo.appointments.constants.locationOptions
import com.example.todo.common.widgets.IconText

@Composable
fun LocationDropdown(
  modifier: Modifier = Modifier,
  locations: List<String> = locationOptions,
  isEditable: Boolean = false,
  onSelected: (String) -> Unit = {}
) {
  var expanded by remember { mutableStateOf(false) }
  Column(modifier = modifier) {
    IconText(
      modifier = if (isEditable) {Modifier.clickable { expanded = !expanded  }} else Modifier,
      icon = Icons.Default.LocationOn,
      contentDesc = "Date picker",
      text = "Select location",
    )
    DropdownMenu(
      offset = DpOffset(20.dp, 0.dp),
      expanded = expanded,
      onDismissRequest = { expanded = false }
    ) {
      Text(text = "Pick location")
      locations.map {
        DropdownMenuItem(
          text = { Text(it) },
          onClick = { onSelected(it) }
        )
      }
    }
  }

}