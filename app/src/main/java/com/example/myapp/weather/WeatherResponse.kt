package com.example.myapp.weather

data class WeatherResponse(
    val main: Main
)

data class Main(
    val temp: Float,
    val pressure: Int,
    val humidity: Int
)
