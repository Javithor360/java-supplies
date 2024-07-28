package com.dwf.insumos.ws.endpoints;

import com.dwf.insumos.ws.model.Supplies;
import com.dwf.insumos.ws.model.dao.SuppliesDAO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;

// http://localhost:8080/insumos-1.0-SNAPSHOT/api/supplies/
@Path("/supplies") // Defines the path for the main endpoint
public class SuppliesRest {

    SuppliesDAO suppliesDAO = new SuppliesDAO(); // Create a new instance of SuppliesDAO

    // Method GET without parameters to retrieve all supplies
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupplies() throws SQLException {
        return Response.status(200).entity(suppliesDAO.findAll()).build(); // Build the response with the supplies as entity
    }

    // Method GET with parameter to retrieve a supply by id
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupply(@PathParam("id") int id) throws SQLException {
        Supplies supply = suppliesDAO.findById(id); // Use DAO method to find a supply by id

        // If supply is null or id is 0, return a 404 response
        // dunno why unexisting supplies return with id 0 so needs to be validated
        if(supply == null || supply.getId() == 0) {
            return Response.status(404).header("Access-Control-Allow-Origin", "*").entity("Supply not found").build();
        }

        return Response.status(200).entity(supply).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON) // What the service is expecting
    @Produces(MediaType.APPLICATION_JSON) // What the service is returning
    public Response createSupply(Supplies supply) throws SQLException {
        // Some kind of validation should be here if needed
        suppliesDAO.insert(supply);

        return Response.status(201).header("Access-Control-Allow-Origin", "*").entity(supply).build();
    }

    //@POST // @DELETE is the correct annotation but doesn't work properly with HTML forms
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    // @Path("delete/{id}")
    public Response deleteSupply(@PathParam("id") int id) throws SQLException {
        Supplies supply = suppliesDAO.findById(id);

        if (supply == null || supply.getId() == 0) {
            return Response.status(400).header("Access-Control-Allow-Origin", "*").entity("Supply apparently doesn't exist").build();
        }

        suppliesDAO.delete(id);

        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Supply deleted").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateSupply(@PathParam("id") int id, Supplies updatedSupply) throws SQLException {
        Supplies supply = suppliesDAO.findById(id);

        if (supply == null || supply.getId() == 0) {
            return Response.status(404).header("Access-Control-Allow-Origin", "*").entity("Supply not found").build();
        }

        supply.setName(updatedSupply.getName());
        supply.setQuantity(updatedSupply.getQuantity());
        supply.setPrice(updatedSupply.getPrice());
        suppliesDAO.update(supply);

        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(supply).build();
    }
}
