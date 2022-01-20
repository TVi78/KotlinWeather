package com.zadania.kotlinweather.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.zadania.kotlinweather.R
import com.zadania.kotlinweather.databinding.MainFragmentBinding
import com.zadania.kotlinweather.model.entites.AppState
import com.zadania.kotlinweather.model.entites.Weather
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {


    private val viewModel: MainViewModel by viewModel()
    private var _binding:MainFragmentBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val observer = Observer<AppState>{
            renderData(it)
        }
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getWeather()
      //  viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private fun renderData(appState: AppState)= with(binding){
        when (appState){
            is AppState.Success -> {
                val weatherData=appState.weatherData
                progressBar.visibility=View.GONE
                weatherGroup.visibility=View.VISIBLE
                setData(weatherData)

            }

            is AppState.Loading -> {
                weatherGroup.visibility=View.INVISIBLE
                progressBar.visibility=View.VISIBLE

            }

            is AppState.Error ->{
                weatherGroup.visibility=View.INVISIBLE
                progressBar.visibility=View.GONE
                Snackbar
                    .make(mainView, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload"){viewModel.getWeather()}
                    .show()

            }
        }
    }

    private fun setData(weatherData: Weather)= with(binding){
        cityName.text=weatherData.city.city
        cityCoordinates.text= String.format(
            getString(R.string.city_coordinates),
            weatherData.city.lat.toString(),
            weatherData.city.lon.toString(),
        )
        temperatureValue.text = weatherData.temperature.toString()
        feelsLikeValue.text =weatherData.feelsLike.toString()
    }

    companion object {
        fun newInstance() = MainFragment()
    }


}