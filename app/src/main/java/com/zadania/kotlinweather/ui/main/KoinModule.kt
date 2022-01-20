package com.zadania.kotlinweather.ui.main

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val  appModule= module {
    //View moduls
    viewModel { MainViewModel() }
}