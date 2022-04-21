package com.example.jetpack_compose_weather_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_weather_app.openWeatherMap.currentWeatherData.CurrentWeather
import com.example.jetpack_compose_weather_app.openWeatherMap.kelvinToCelsius
import com.example.jetpack_compose_weather_app.ui.H2
import com.example.jetpack_compose_weather_app.ui.H3
import com.example.jetpack_compose_weather_app.ui.H5

fun mapWeatherCodeToEmoji(weatherIconString: String): Int = when (weatherIconString) {
    "01d" -> R.drawable.clear_sky
    "02d" -> R.drawable.few_clouds
    "03d" -> R.drawable.scattered_clouds
    "04d" -> R.drawable.broken_clouds
    "09d" -> R.drawable.shower_rain
    "10d" -> R.drawable.rain
    "11d" -> R.drawable.thunderstorm
    "13d" -> R.drawable.snow
    "50d" -> R.drawable.mist
    else -> -1
}

@Composable
fun CurrentWeatherCard(weather: CurrentWeather) {
    Card(elevation = 12.dp) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val weatherInfo = weather.weather.first()
            H2(text = weather.locationName)
            Image(
                painter = painterResource(id = mapWeatherCodeToEmoji(weatherIconString = weatherInfo.icon)),
                contentDescription = null,
                modifier = Modifier.size(256.dp)
            )
            H5(text = weatherInfo.description)
            H3(text = "${weather.mainWeatherInfo.temp.kelvinToCelsius().toInt()} °C")
        }
    }

}
