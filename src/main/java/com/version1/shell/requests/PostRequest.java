package com.version1.shell.requests;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostRequest implements Request {

    @Override
    public void send(String url, String body) {
        // Create client for sending request
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("\nStatus Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body()+ "\n");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void send(String url){
    }
}
