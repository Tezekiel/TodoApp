package com.example.todo.widget

import android.util.Log
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.todo.constants.locationOptions

@Composable
fun LocationDropdown(
  modifier: Modifier = Modifier,
  locations: List<String> = locationOptions,
) {
  var expanded by remember { mutableStateOf(false) }
  Column(modifier = modifier) {
    IconText(
      modifier = Modifier.clickable { expanded = !expanded  },
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
          onClick = { Log.d("karlo", "AppointmentRow: $it") }
        )
      }
    }
    //todo add error state
  }

}