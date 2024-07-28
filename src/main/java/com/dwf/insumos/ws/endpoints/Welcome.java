package com.dwf.insumos.ws.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/welcome")
public class Welcome {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getWelcome() {
        return "Welcome to the Insumos Web Service!";
    }
}
