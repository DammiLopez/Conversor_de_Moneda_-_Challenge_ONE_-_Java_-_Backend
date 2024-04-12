package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import models.ExchangeRate;

public class ApiConnection {

    public ExchangeRate findCoin(String country) {

        URI endpoint = URI.create("https://v6.exchangerate-api.com/v6/4d411d0ba460fe0cde6bb356/latest/" + country);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endpoint)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRate.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
