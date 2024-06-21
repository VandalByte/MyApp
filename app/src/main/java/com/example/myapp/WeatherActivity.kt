package com.example.myapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.weather.WeatherService
import com.example.myapp.weather.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherActivity : AppCompatActivity() {

    private lateinit var cityInput: EditText
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        cityInput = findViewById(R.id.cityInput)
        resultText = findViewById(R.id.resultText)
    }

    fun onFetchButtonClick(view: View) {
        val cityName = cityInput.text.toString()
        if (cityName.isNotEmpty()) {
            fetchWeatherData(cityName)
        }
    }

    private fun fetchWeatherData(cityName: String) {
        val weatherService = WeatherService.create()
        weatherService.getWeather(cityName, Secrets.WEATHER_API_KEY)
            .enqueue(object : Callback<WeatherResponse> {
                override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                    if (response.isSuccessful) {
                        response.body()?.let { weatherResponse ->
                            resultText.text = "Temperature: ${weatherResponse.main.temp}°C\n" +
                                    "Humidity: ${weatherResponse.main.humidity}%\n" +
                                    "Pressure: ${weatherResponse.main.pressure} hPa"
                        }
                    } else {
                        Log.e("WeatherActivity", "Error: ${response.code()} ${response.message()}")
                        resultText.text = "Error fetching data: ${response.message()}"
                    }
                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    Log.e("WeatherActivity", "Failure: ${t.message}", t)
                    resultText.text = "Error fetching data"
                }
            })
    }
}
