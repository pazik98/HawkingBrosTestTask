package ru.pazik98.HawkingBrosTestTask.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pazik98.HawkingBrosTestTask.model.CurrentWeatherData;
import ru.pazik98.HawkingBrosTestTask.parser.CurrentWeatherDataParser;
import ru.pazik98.HawkingBrosTestTask.requester.GismeteoRequester;

@Service
@AllArgsConstructor
public class GismeteoService implements WeatherService {
    private final GismeteoRequester gismeteoRequester;
    private final CurrentWeatherDataParser weatherDataParser;
    @Override
    public CurrentWeatherData getCurrentWeather(String latitude, String longitude) {
        return weatherDataParser.parse(gismeteoRequester.send(latitude, longitude));
    }
}
