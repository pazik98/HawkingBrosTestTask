package ru.pazik98.HawkingBrosTestTask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pazik98.HawkingBrosTestTask.model.MessageA;
import ru.pazik98.HawkingBrosTestTask.model.MessageB;
import ru.pazik98.HawkingBrosTestTask.service.GismeteoService;
import ru.pazik98.HawkingBrosTestTask.service.WeatherService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MessageController {
    public final GismeteoService gismeteoService;

    @RequestMapping("api/1/adapter")
    public ResponseEntity<String> adapter(@RequestBody MessageA messageA) {
        var msg = Optional.ofNullable(messageA.getMsg()).orElse("");
        if (msg.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Field \"msg\" is empty.");
        }

        var lng = Optional.ofNullable(messageA.getLng()).orElse("");
        if (!lng.equals("ru")) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Field \"lng\" must be \"ru\".");
        }

        var currentWeather = gismeteoService.getCurrentWeather(
                messageA.getLng(),
                messageA.getCoordinates().getLatitude(),
                messageA.getCoordinates().getLongitude()
        );
        if (currentWeather == null) return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Weather service is unavailable.");
        var messageB = MessageB.from(messageA, currentWeather);


        return ResponseEntity.ok().body(null);
    }

}
