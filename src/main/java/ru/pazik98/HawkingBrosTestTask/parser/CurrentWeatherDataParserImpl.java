package ru.pazik98.HawkingBrosTestTask.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.pazik98.HawkingBrosTestTask.model.CurrentWeatherData;

import java.time.LocalDateTime;

@Service
public class CurrentWeatherDataParserImpl implements CurrentWeatherDataParser {
    @Override
    public CurrentWeatherData parse(String weatherDataAsString) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json;
        try {
            json = mapper.readTree(weatherDataAsString);
            return CurrentWeatherData.builder()
                    .temperature((int) Double.parseDouble(json.get("temperature").get("air").get("C").asText()))
                    .dateTime(LocalDateTime.parse(json.get("date").get("UTC").asText().replace(" ", "T")))
                    .build();
        } catch (JsonProcessingException | NullPointerException e) {
            return null;
        }
    }
}
