package ru.pazik98.HawkingBrosTestTask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

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
                .createdDt(currentWeatherData.getDateTime())
                .currentTemp(currentWeatherData.getTemperature())
                .build();
    }
}
