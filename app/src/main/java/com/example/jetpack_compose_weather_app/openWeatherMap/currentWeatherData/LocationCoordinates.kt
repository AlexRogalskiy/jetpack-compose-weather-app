package com.example.jetpack_compose_weather_app.openWeatherMap.currentWeatherData

import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat") val latitude: String,
    @SerializedName("lon") val longitude: String
)

data class LocationCoordinates(
    @SerializedName("coord") val coordinates: Coord,
)
