package com.example.jetpack_compose_weather_app.openWeatherMap.sevenDaysWeatherForecast

import com.google.gson.annotations.SerializedName

data class Temperature(
    @SerializedName("day") val day: Float,
    @SerializedName("min") val min: Float,
    @SerializedName("max") val max: Float,
    @SerializedName("night") val night: Float,
    @SerializedName("eve") val evening: Float,
    @SerializedName("morn") val morning: Float
)

data class FeelsLike(
    @SerializedName("day") val day: Float,
    @SerializedName("night") val night: Float,
    @SerializedName("evening") val evening: Float,
    @SerializedName("morning") val morning: Float
)

data class Weather(
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String,
)

data class DailyForecast(
    @SerializedName("dt") val unixTime: Long,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long,
    @SerializedName("moonrise") val moonrise: Long,
    @SerializedName("moonset") val moonset: Long,
    @SerializedName("moon_phase") val moonPhase: Float,
    @SerializedName("temp") val temperature: Temperature,
    @SerializedName("feels_like") val feelsLike: FeelsLike,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("dew_point") val dewPoint: Float,
    @SerializedName("wind_speed") val windSpeed: Float,
    @SerializedName("wind_deg") val windDegree: Float,
    @SerializedName("wind_gust") val windGust: Float,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("clouds") val clouds: Int
)

data class Forecast(
    @SerializedName("lat") val latitude: Float,
    @SerializedName("lon") val longitude: Float,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("timezone_offset") val timezoneOffset: Int,
    @SerializedName("daily") val dailyForecast: List<DailyForecast>,
)
