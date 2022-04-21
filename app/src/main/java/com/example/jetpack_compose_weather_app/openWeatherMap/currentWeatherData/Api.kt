package com.example.jetpack_compose_weather_app.openWeatherMap.currentWeatherData

import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("weather?appid=612484d7c358a741d0646892ee97219b") // TODO: store api-key somewhere safe...
    suspend fun getByLocation(
        @Query("q") location: String
    ): CurrentWeather
}
