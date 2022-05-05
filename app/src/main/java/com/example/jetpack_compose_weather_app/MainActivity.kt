package com.example.jetpack_compose_weather_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_weather_app.ui.theme.JetpackcomposeweatherappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        setContent {
            JetpackcomposeweatherappTheme {
                Scaffold(topBar = {
                    TopAppBar(backgroundColor = Color.Cyan) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(onClick = { println("back") }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = null)
                            }
                            Text(text = "Jonners simple weatherapp")
                        }
                    }
                }, content = { innerPadding ->
                    WeatherSearchScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(paddingValues = innerPadding)
                    )
                })
            }
        }
    }
}

@Composable
fun WeatherSearchScreen(
    viewModel: MainViewModel,
    modifier: Modifier
) {
    var city by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Search") },
            maxLines = 1
        )
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = {
                    viewModel.fetchWeather(city)
                    viewModel.getWeatherForecast1(city)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
            ) {
                Row {
                    Text(text = "Search")
                }
            }
            Button(
                onClick = {
                    city = ""
                    viewModel.resetWeatherForecast()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
            ) {
                Row {
                    Text(text = "Reset")
                }
            }
        }
        LazyColumn {
            viewModel.fetchedWeather.value?.let {
                item {
                    CurrentWeatherCard(weather = it)
                }

            }
            item {
                Text(text = viewModel.weatherForecast.value.toString())
            }
        }

    }
}

