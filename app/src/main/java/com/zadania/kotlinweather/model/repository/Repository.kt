package com.zadania.kotlinweather.model.repository

import com.zadania.kotlinweather.model.entites.Weather

interface Repository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorage(): Weather
}