package ru.pazik98.HawkingBrosTestTask.requester;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.pazik98.HawkingBrosTestTask.model.MessageB;

import java.net.URI;
import java.net.http.HttpRequest;

@Service
@RequiredArgsConstructor
public class ServiceBRequester {
    private final Requester requester;

    @Value("app.service.b.url")
    private String serviceBUrl;

    public int send(MessageB messageB) {
        String messageAsString = "";
        try {
            messageAsString = new ObjectMapper().writeValueAsString(messageB);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serviceBUrl))
                .POST(HttpRequest.BodyPublishers.ofString(messageAsString))
                .build();
        return requester.send(request).statusCode();
    }
}
