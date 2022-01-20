package com.zadania.kotlinweather.ui.main

import com.zadania.kotlinweather.model.repository.Repository
import com.zadania.kotlinweather.model.repository.RepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val  appModule= module {
    single<Repository>{RepositoryImpl()}
    //View moduls
    viewModel { MainViewModel(get()) }
}