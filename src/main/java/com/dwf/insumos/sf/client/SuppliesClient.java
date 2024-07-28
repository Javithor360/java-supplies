package com.dwf.insumos.sf.client;

import com.dwf.insumos.sf.model.Supplies;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class SuppliesClient {

    private static final String BASE_URI = "http://localhost:8080/insumos-1.0-SNAPSHOT/api/supplies";
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ArrayList<Supplies> getAllSupplies() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URI)).header("Accept", "application/json").GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), new TypeReference<ArrayList<Supplies>>() {});
    }

    public Supplies getSupply(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URI + "/" + id)).header("Accept", "application/json").GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Supplies.class);
    }

    public void createSupply(Supplies supply) throws IOException, InterruptedException {
        String requestBody = objectMapper.writeValueAsString(supply);

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URI)).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();

        client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void updateSupply(int id, Supplies supply) throws IOException, InterruptedException {
        String requestBody = objectMapper.writeValueAsString(supply);

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URI + "/" + id)).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();

        client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void deleteSupply (int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URI + "/" + id)).DELETE().build();

        client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
