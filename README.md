# Weather App Native - Android Compose

An Android Kotlin Compose application that fetches and displays weather temperature for any city using the wttr.in API.

Testing a very simple native Kotlin Compose App to Compare it with the Kotlin Flutter app in other repos https://github.com/Shady-Selim/WeatherApp


## Features

- ✅ Modern Jetpack Compose UI
- ✅ Text field for city name input
- ✅ Real-time temperature fetching
- ✅ Clean Material Design 3 interface

## Setup

### Prerequisites
- Android Studio Hedgehog (2023.1.1) or later
- Android SDK with API level 24+ (Android 7.0)
- Java JDK 11 or higher

### Build and Run

1. Open the project in Android Studio:
   ```bash
   cd ~/AndroidStudioProjects/WeatherAppNative
   ```

2. Sync Gradle files (Android Studio will do this automatically)

3. Run the app on an emulator or device

## Usage

1. Enter a city name in the text field (e.g., "London", "New York", "Tokyo")
2. Tap the "Get Weather" button
3. The current temperature in Celsius will be displayed
4. Other information like humaiditity and condition will be displayed also
   
## API Details

The app uses the [wttr.in](https://wttr.in) weather service:
- **Endpoint**: `https://wttr.in/{cityName}?format=j1`
- **Format**: JSON
- **Free**: No API key required
- **Temperature**: Returns in Celsius

## Dependencies

- **Jetpack Compose**: Modern declarative UI framework
- **Material Design 3**: Material You design system
- **Ktor**: HTTP client for API calls
## License

This project is provided as-is for educational purposes.
