package com.example.jetpack_compose_weather_app.openWeatherMap.sevenDaysWeatherForecast

import com.example.jetpack_compose_weather_app.openWeatherMap.Urls
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    companion object {
        private fun retrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun createSevenDaysWeatherForecast(): Api {
            return retrofit().create(Api::class.java)
        }
    }
}
