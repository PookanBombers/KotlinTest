package com.example.kotlintest.view.weatherlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintest.R
import com.example.kotlintest.databinding.FragmentWeatherlistBinding
import com.example.kotlintest.viewmodel.AppState


class WeatherListFragment : Fragment(R.layout.fragment_weatherlist) {

    private var _binding: FragmentWeatherlistBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = WeatherListFragment()
    }

    private lateinit var viewModel: WeatherListViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherListViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner) { renderData(it) }
        viewModel.simulateRequestToServer()
    }

    private fun renderData(appState: AppState) {
        when (appState) {

            is AppState.Error -> {

                binding.loadingLayout.visibility = View.GONE

                Toast.makeText(
                    requireActivity(),
                    appState.error.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }

            AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
            }

            is AppState.Success -> {
                val result = appState.weatherData

                with(binding) {
                    loadingLayout.visibility = View.GONE
                    cityName.text = result.city.city
                    temperatureValue.text = result.temperature.toString()
                    feelsLikeLabel.text = result.feelsLike.toString()
                    cityCoordinates.text = "${result.city.lat} / ${result.city.lon}"
                }
                Toast.makeText(requireContext(), "Работает", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
