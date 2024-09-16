package ru.pazik98.HawkingBrosTestTask.requester;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class GismeteoRequester {
    private static final String API_TOKEN = "${gismeteo.api.token}";
    private final HttpClient client = HttpClient.newHttpClient();

    public String request(HttpRequest request) {
        
    }
}
