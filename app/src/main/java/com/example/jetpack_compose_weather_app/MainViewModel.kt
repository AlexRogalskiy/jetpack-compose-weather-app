package com.example.jetpack_compose_weather_app

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_compose_weather_app.openWeatherMap.currentWeatherData.CurrentWeather
import com.example.jetpack_compose_weather_app.openWeatherMap.currentWeatherData.Service
import kotlinx.coroutines.launch

enum class State {
    INITIAL,
    FAILED,
    LOADING,
    SUCCESS
}

class MainViewModel : ViewModel() {
    var fetchedWeather: MutableState<CurrentWeather?> = mutableStateOf(null)
        private set
    var state: MutableState<State> = mutableStateOf(State.INITIAL)
        private set

    var city: MutableState<String> = mutableStateOf("")

    private val currentWeatherService = Service.createCurrentWeatherService()

    fun fetchWeather(city: String) {
        if (city.isNotBlank()) {
            state.value = State.LOADING
            viewModelScope.launch {
                fetchedWeather.value = currentWeatherService.getByLocation(city)
            }
        }
    }
}
