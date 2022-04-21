package com.example.jetpack_compose_weather_app.openWeatherMap.currentWeatherData

import com.example.jetpack_compose_weather_app.openWeatherMap.keys
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("weather?appid=${keys.OPEN_WEATHER_API_KEY}")
    suspend fun getByLocation(
        @Query("q") location: String
    ): CurrentWeather
}
