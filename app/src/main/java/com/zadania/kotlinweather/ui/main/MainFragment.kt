package com.zadania.kotlinweather.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zadania.kotlinweather.R
import com.zadania.kotlinweather.databinding.MainFragmentBinding
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
      //  viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    companion object {
        fun newInstance() = MainFragment()
    }


}