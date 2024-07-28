package com.dwf.insumos.sf.mbeans;

import com.dwf.insumos.sf.model.Supplies;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;

import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@ManagedBean(name = "suppliesBean")
public class SuppliesBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String BASE_URL = "http://localhost:8080/insumos-1.0-SNAPSHOT/api/supplies";

    private ArrayList<Supplies> supplies;
    private Supplies newSupply = new Supplies();
    private Supplies selectedSupply;

    @PostConstruct
    public void init() {
        fetchSupplies();
    }

    public void fetchSupplies() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                supplies = objectMapper.readValue(response.body(), new TypeReference<ArrayList<Supplies>>() {});
            } else {
                System.out.println("GET request didn't work. Status code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createSupply() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL)).POST(HttpRequest.BodyPublishers.ofString(new ObjectMapper().writeValueAsString(newSupply))).header("Content-Type", "application/json").build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 201) {
                fetchSupplies();
                newSupply = new Supplies(); // Reset the newSupply object after creation
            } else {
                System.out.println("POST request didn't work. Status code: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSupply() {
        if (selectedSupply != null) {
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL + "/delete/" + selectedSupply.getId())).POST(HttpRequest.BodyPublishers.noBody()).build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    fetchSupplies();
                } else {
                    System.out.println("DELETE request not worked, Status code: " + response.statusCode());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Supplies> getSupplies() {
        return supplies;
    }

    public Supplies getNewSupply() {
        return newSupply;
    }

    public void setNewSupply(Supplies newSupply) {
        this.newSupply = newSupply;
    }

    public Supplies getSelectedSupply() {
        return selectedSupply;
    }

    public void setSelectedSupply(Supplies selectedSupply) {
        this.selectedSupply = selectedSupply;
    }
}