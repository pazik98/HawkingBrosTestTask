package ru.pazik98.HawkingBrosTestTask.service;

import ru.pazik98.HawkingBrosTestTask.model.CurrentWeatherData;

public interface WeatherService {
    CurrentWeatherData getCurrentWeather(String latitude, String longitude);
}
