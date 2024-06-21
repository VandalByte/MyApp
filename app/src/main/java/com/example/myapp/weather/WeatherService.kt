package com.example.myapp.weather

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): retrofit2.Call<WeatherResponse>

    companion object {
        private const val BASE_URL = "http://api.openweathermap.org/data/2.5/"

        fun create(): WeatherService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(WeatherService::class.java)
        }
    }
}
