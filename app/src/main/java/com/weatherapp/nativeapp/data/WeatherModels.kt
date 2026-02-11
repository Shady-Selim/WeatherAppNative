package com.weatherapp.nativeapp.data

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val current_condition: List<CurrentCondition>,
    val nearest_area: List<NearestArea>
)

@Serializable
data class CurrentCondition(
    val temp_C: String,
    val humidity: String,
    val weatherDesc: List<WeatherValue>,
    val weatherIconUrl: List<WeatherValue>
)

@Serializable
data class NearestArea(
    val areaName: List<WeatherValue>,
    val country: List<WeatherValue>
)

@Serializable
data class WeatherValue(
    val value: String
)
