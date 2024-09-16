package ru.pazik98.HawkingBrosTestTask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Value
@Builder
@AllArgsConstructor
public class MessageB {
    String txt;
    LocalDateTime createdDt;
    int currentTemp;

    public static MessageB from(MessageA messageA, CurrentWeatherData currentWeatherData) {
        return MessageB.builder()
                .txt(messageA.getMsg())
                .createdDt(LocalDateTime.parse(currentWeatherData.getDateTime().format(DateTimeFormatter.ISO_INSTANT)))
                .currentTemp(currentWeatherData.getTemperature())
                .build();
    }
}
