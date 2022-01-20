package com.zadania.kotlinweather.model.repository

import com.zadania.kotlinweather.model.entites.Weather

class RepositoryImpl: Repository {
    override fun getWeatherFromServer()= Weather()
    override fun getWeatherFromLocalStorage()= Weather()
}