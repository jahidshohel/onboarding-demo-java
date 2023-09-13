package com.eng.onboarding.te;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newBuilder;

public class RemoteMaths {

    private final String serviceUrl = "http://api.mathjs.org/v4/";

    public long factorial(int a) throws IOException, InterruptedException {
        String body = send(serviceUrl + "?expr=factorial(" + a + ")");
        return Long.parseLong(body);
    }

    public int permutations(int a) throws IOException, InterruptedException {
        String body = send(serviceUrl + "?expr=permutations(" + a + ")");
        return Integer.parseInt(body);
    }

    private String send(String url) throws IOException, InterruptedException {
        HttpClient client = newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new RuntimeException(response.toString());
        }
        return response.body();
    }
}
