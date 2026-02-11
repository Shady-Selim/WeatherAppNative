package com.weatherapp.nativeapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weatherapp.nativeapp.data.WeatherApi
import com.weatherapp.nativeapp.data.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class WeatherUiState {
    object Loading : WeatherUiState()
    data class Success(val data: WeatherResponse) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}

class WeatherViewModel : ViewModel() {
    private val api = WeatherApi() // Manual instantiation, no DI

    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val uiState: StateFlow<WeatherUiState> = _uiState

    init {
        getWeather("London")
    }

    fun getWeather(city: String) {
        viewModelScope.launch {
            _uiState.value = WeatherUiState.Loading
            try {
                val response = api.fetchWeather(city)
                _uiState.value = WeatherUiState.Success(response)
            } catch (e: Exception) {
                _uiState.value = WeatherUiState.Error(e.message ?: "Unknown error")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        api.close()
    }
}
