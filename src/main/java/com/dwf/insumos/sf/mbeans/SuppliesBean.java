package com.dwf.insumos.sf.mbeans;

import com.dwf.insumos.sf.client.SuppliesClient;
import com.dwf.insumos.sf.model.Supplies;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class SuppliesBean implements Serializable {

    private SuppliesClient suppliesClient = new SuppliesClient();
    private List<Supplies> supplies;
    private Supplies newSupply = new Supplies();
    private String message;

    @PostConstruct
    public void init() {
        try {
            supplies = suppliesClient.getAllSupplies();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Supplies> getSupplies() {
        return supplies;
    }

    public Supplies getNewSupply() {
        return newSupply;
    }

    public void setNewSupply(Supplies newSupply) {
        this.newSupply = newSupply;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String createSupply() {
        try {
            // Validations
            if (newSupply.getName() == null || newSupply.getName().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Name cannot be empty", null));
                return null;
            }
            if (newSupply.getQuantity() <= 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Quantity must be a positive integer", null));
                return null;
            }
            if (newSupply.getPrice() <= 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Price must be a positive number", null));
                return null;
            }

            // If no validation errors, create the supply
            suppliesClient.createSupply(newSupply);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("successMessage", "Supply created successfully!");
            return goBack();
        } catch (IOException | InterruptedException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error creating supply: " + e.getMessage(), null));
            return null;
        }
    }

    public String goToCreateForm() {
        return "createSupply?faces-redirect=true";
    }

    public String goBack() {
        return "index?faces-redirect=true";
    }
}
