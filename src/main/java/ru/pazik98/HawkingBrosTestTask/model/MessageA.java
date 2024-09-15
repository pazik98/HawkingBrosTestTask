package ru.pazik98.HawkingBrosTestTask.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class MessageA {
    String msg;
    String lng;
    Coordinates coordinates;

    @Value
    @Builder
    @AllArgsConstructor(onConstructor = @__(@JsonCreator))
    public static class Coordinates {
        String latitude;
        String longitude;
    }
}
