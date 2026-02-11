package com.weatherapp.nativeapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    var cityInput by remember { mutableStateOf("London") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Native Weather App (wttr.in)") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = cityInput,
                onValueChange = { cityInput = it },
                label = { Text("Enter City") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = { viewModel.getWeather(cityInput) },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Get Weather")
            }

            Spacer(modifier = Modifier.height(24.dp))

            when (val state = uiState) {
                is WeatherUiState.Loading -> CircularProgressIndicator()
                is WeatherUiState.Success -> {
                    val weather = state.data
                    val current = weather.current_condition.firstOrNull()
                    val area = weather.nearest_area.firstOrNull()
                    
                    if (current != null) {
                        Text(
                            text = "City: ${area?.areaName?.firstOrNull()?.value ?: "Unknown"}", 
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            text = "Temp: ${current.temp_C}°C", 
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Humidity: ${current.humidity}%", 
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Condition: ${current.weatherDesc.firstOrNull()?.value ?: "N/A"}"
                        )
                    } else {
                        Text("No weather data found.")
                    }
                }
                is WeatherUiState.Error -> {
                    Text(text = "Error: ${state.message}", color = MaterialTheme.colorScheme.error)
                }
            }
        }
    }
}
