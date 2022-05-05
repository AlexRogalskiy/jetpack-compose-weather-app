package com.example.jetpack_compose_weather_app.openWeatherMap.currentWeatherData

import com.example.jetpack_compose_weather_app.openWeatherMap.keys
import retrofit2.http.GET
import retrofit2.http.Query

const val currentWeatherRoute = "weather?appid=${keys.OPEN_WEATHER_API_KEY}"

interface Api {
    @GET(currentWeatherRoute)
    suspend fun getByLocation(
        @Query("q") location: String
    ): CurrentWeather

    @GET(currentWeatherRoute)
    suspend fun getCoordinatesByLocationName(
        @Query("q") location: String
    ): LocationCoordinates
}
