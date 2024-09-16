package ru.pazik98.HawkingBrosTestTask.requester;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.pazik98.HawkingBrosTestTask.parser.CurrentWeatherDataParser;
import ru.pazik98.HawkingBrosTestTask.service.WeatherService;

import java.net.URI;
import java.net.http.HttpRequest;

@Service
@RequiredArgsConstructor
public class GismeteoRequester implements WeatherRequester {
    private final Requester requester;
    @Value("${gismeteo.api.url.weather.current}")
    private String currentWeatherUrl;

    @Value("${gismeteo.api.token}")
    private String API_TOKEN;

    @Override
    public String send(String latitude, String longitude) {
        String url =  currentWeatherUrl + "?latitude=%s&longitude=%s"
                .formatted(latitude, longitude);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("X-Gismeteo-Token", API_TOKEN)
                .build();

        return requester.send(request).body();
    }
}
