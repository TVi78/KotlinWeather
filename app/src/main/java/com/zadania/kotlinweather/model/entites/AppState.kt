package com.zadania.kotlinweather.model.entites

sealed class AppState {
    data class Success(val weatherData: Weather): AppState()
    data class Error(val error: Throwable): AppState()
    object Loading: AppState()
}
