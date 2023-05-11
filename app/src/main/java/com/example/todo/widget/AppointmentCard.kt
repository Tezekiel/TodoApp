package com.example.todo.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.helpers.nowDate
import com.example.todo.helpers.nowTime

@Composable
fun AppointmentCard(
  modifier: Modifier = Modifier
) {
  var date: String by remember { mutableStateOf(nowDate()) }
  var time: String by remember { mutableStateOf(nowTime()) }

  Card(
    shape = RoundedCornerShape(8.dp),
    modifier = modifier
      .fillMaxWidth()
      .padding(16.dp, 8.dp),
    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
  ) {
    Column(
      modifier = Modifier.padding(8.dp),
      verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
      IconText(
        icon = Icons.Default.Edit,
        contentDesc = "Appointment description",
        text = "Your appointment description goes here",
      )
      DatePicker(value = date, onValueChange = { date = it })
      TimePicker(value = time, onValueChange = { time = it })
      LocationDropdown()
    }
  }
}

@Preview(showBackground = true)
@Composable
fun AppointmentRowPreview() {
  AppointmentCard()
}