package ru.pazik98.HawkingBrosTestTask.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class CurrentWeatherData {
    int temperature;
    LocalDateTime dateTime;
}
