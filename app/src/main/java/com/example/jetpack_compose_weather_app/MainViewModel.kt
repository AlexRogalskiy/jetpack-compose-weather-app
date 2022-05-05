package com.example.jetpack_compose_weather_app

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_compose_weather_app.openWeatherMap.currentWeatherData.CurrentWeather
import com.example.jetpack_compose_weather_app.openWeatherMap.currentWeatherData.LocationCoordinates
import com.example.jetpack_compose_weather_app.openWeatherMap.sevenDaysWeatherForecast.Forecast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.jetpack_compose_weather_app.openWeatherMap.currentWeatherData.Service as CurrentWeatherDataService
import com.example.jetpack_compose_weather_app.openWeatherMap.sevenDaysWeatherForecast.Service as SevenDaysWeatherForecastService

enum class State {
    INITIAL,
    FAILED,
    LOADING,
    SUCCESS
}

class MainViewModel : ViewModel() {
    var state: MutableState<State> = mutableStateOf(State.INITIAL)
        private set
    var fetchedWeather: MutableState<CurrentWeather?> = mutableStateOf(null)
        private set
    var currentWeatherCoordinates: MutableState<LocationCoordinates?> = mutableStateOf(null)
        private set
    var weatherForecast: MutableState<Forecast?> = mutableStateOf(null)
        private set

    private val currentWeatherService = CurrentWeatherDataService.createCurrentWeatherService()
    private val weatherForecastService =
        SevenDaysWeatherForecastService.createSevenDaysWeatherForecast()

    fun getWeatherForecast1(location: String) {
        getWeatherForecast(location = location)
        Log.d("logers", weatherForecast.toString())
    }

    fun resetWeatherForecast() {
        weatherForecast.value = null
    }

    fun fetchWeather(city: String) {
        if (city.isNotBlank()) {
            state.value = State.LOADING
            try {
                viewModelScope.launch {
                    fetchedWeather.value = currentWeatherService.getByLocation(city)
                }
                state.value = State.SUCCESS
            } catch (_: Exception) {
                state.value = State.FAILED
            }

        }
    }

    private fun getCoordinates(location: String) {
        if (location.isNotBlank()) {
            state.value = State.LOADING
            try {
                viewModelScope.launch {
                    currentWeatherCoordinates.value =
                        currentWeatherService.getCoordinatesByLocationName(location)
                }
                state.value = State.SUCCESS
            } catch (_: Exception) {
                state.value = State.FAILED
            }
        }
    }

    private fun getWeatherForecast(location: String) {
        getCoordinates(location = location)
        state.value = State.LOADING
        try {
            currentWeatherCoordinates.value?.let {
                viewModelScope.launch {
                    weatherForecast.value =
                        weatherForecastService.getSevenDaysForecast(
                            it.coordinates.latitude,
                            it.coordinates.longitude
                        )
                }
            }
            state.value = State.SUCCESS
        } catch (_: Exception) {
            state.value = State.FAILED
        }
    }
}
