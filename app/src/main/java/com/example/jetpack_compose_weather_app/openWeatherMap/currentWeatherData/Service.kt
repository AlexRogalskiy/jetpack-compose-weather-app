package com.example.jetpack_compose_weather_app.openWeatherMap.currentWeatherData

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL: String = "https://api.openweathermap.org/data/2.5/"

class Service {
    companion object {
        private fun retrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun createCurrentWeatherService(): Api {
            return retrofit().create(Api::class.java)
        }
    }

}
