package com.zadania.kotlinweather.model.entites

import com.zadania.kotlinweather.model.entites.City

data class Weather(
    val city: City =getDefaultCity(),
    val temperature: Int=0,
    val feelsLike: Int=0
)
 fun getDefaultCity()= City("Москва", 55.75, 37.61)