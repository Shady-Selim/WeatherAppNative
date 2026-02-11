package com.weatherapp.nativeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.weatherapp.nativeapp.ui.WeatherScreen
import com.weatherapp.nativeapp.ui.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val viewModel: WeatherViewModel = viewModel()
                    WeatherScreen(viewModel = viewModel)
                }
            }
        }
    }
}
