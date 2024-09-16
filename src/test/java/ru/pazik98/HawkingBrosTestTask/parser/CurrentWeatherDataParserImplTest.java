package ru.pazik98.HawkingBrosTestTask.parser;

import org.junit.jupiter.api.Test;
import ru.pazik98.HawkingBrosTestTask.model.CurrentWeatherData;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CurrentWeatherDataParserImplTest {

    @Test
    void parseTest() throws IOException, URISyntaxException {
        var parser = new CurrentWeatherDataParserImpl();
        var uri = ClassLoader.getSystemResource("gismeteo_api_response.json").toURI();
        var weatherDataAsString = Files.readString(Paths.get(uri), Charset.defaultCharset());

        var weatherData = parser.parse(weatherDataAsString);

        assertThat(weatherData.getTemperature()).isEqualTo(getCurrentWeatherData().getTemperature());
        assertThat(weatherData.getDateTime()).isEqualTo(getCurrentWeatherData().getDateTime());
    }

    CurrentWeatherData getCurrentWeatherData() {
        return CurrentWeatherData.builder()
                .temperature((int) 12.6)
                .dateTime(LocalDateTime.parse("2016-02-01T11:00:00"))
                .build();
    }
}
