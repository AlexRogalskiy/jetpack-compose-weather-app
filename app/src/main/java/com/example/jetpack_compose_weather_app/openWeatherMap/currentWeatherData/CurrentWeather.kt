package com.example.jetpack_compose_weather_app.openWeatherMap.currentWeatherData

import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("lon") val longitude: Float,
    @SerializedName("lat") val latitude: Float,
)

data class Weather(
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)

data class MainWeatherInfo(
    @SerializedName("temp") val temp: Float,
    @SerializedName("feels_like") val feelsLike: Float,
    @SerializedName("temp_min") val tempMin: Float,
    @SerializedName("temp_max") val tempMax: Float,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("humidity") val humidity: Int
)

data class Wind(
    @SerializedName("speed") val speed: Float,
    @SerializedName("deg") val degrees: Int
)

data class Info(
    @SerializedName("country") val country: String,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long
)

data class CurrentWeather(
    @SerializedName("coord")
    val coordinates: Coordinates,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("main")
    val mainWeatherInfo: MainWeatherInfo,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("wind")
    val wind: Wind,
    @SerializedName("sys")
    val info: Info,
    @SerializedName("timezone")
    val timeZone: Int,
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val locationName: String
)
