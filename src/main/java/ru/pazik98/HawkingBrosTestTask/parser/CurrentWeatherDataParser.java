package ru.pazik98.HawkingBrosTestTask.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import ru.pazik98.HawkingBrosTestTask.model.CurrentWeatherData;

public interface CurrentWeatherDataParser {

    CurrentWeatherData parse(String weatherDataAsString);
}
