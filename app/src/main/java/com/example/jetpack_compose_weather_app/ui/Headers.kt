package com.example.jetpack_compose_weather_app.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun H2(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h2,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun H3(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h3,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun H4(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h4,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun H5(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(8.dp)
    )
}
