package com.dwf.insumos.ws.endpoints;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/welcome")
public class Welcome {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getWelcome() {
        return "Welcome to the Insumos Web Service!";
    }
}
