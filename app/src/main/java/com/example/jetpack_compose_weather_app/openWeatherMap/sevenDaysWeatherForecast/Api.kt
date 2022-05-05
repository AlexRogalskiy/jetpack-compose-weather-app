package com.example.jetpack_compose_weather_app.openWeatherMap.sevenDaysWeatherForecast

import com.example.jetpack_compose_weather_app.openWeatherMap.keys
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("onecall?appid=${keys.OPEN_WEATHER_API_KEY}&exclude=minutely,hourly,current,alerts&units=metric")
    suspend fun getSevenDaysForecast(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String
    ): Forecast
}
