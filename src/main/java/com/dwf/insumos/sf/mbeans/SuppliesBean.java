package com.dwf.insumos.sf.mbeans;

import com.dwf.insumos.sf.client.SuppliesClient;
import com.dwf.insumos.sf.model.Supplies;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class SuppliesBean implements Serializable {

    private SuppliesClient suppliesClient = new SuppliesClient();
    private List<Supplies> supplies;
    private Supplies supply = new Supplies(); // Use a single 'supply' property for both creation and editing
    private boolean isEditing = false; // To check if we are editing
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

    public Supplies getSupply() {
        return supply;
    }

    public void setSupply(Supplies supply) {
        this.supply = supply;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getIsEditing() {
        return isEditing;
    }

    public void setEditing(boolean editing) {
        isEditing = editing;
    }

    public String createSupply() {
        try {
            // Validations
            if (supply.getName() == null || supply.getName().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Name cannot be empty", null));
                return null;
            }
            if (supply.getQuantity() <= 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Quantity must be a positive integer", null));
                return null;
            }
            if (supply.getPrice() <= 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Price must be a positive number", null));
                return null;
            }

            if (isEditing) {
                // If we are editing, call the update method
                suppliesClient.updateSupply(supply.getId(), supply);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().put("successMessage", "Supply updated successfully!");
            } else {
                // If we are creating, call the create method
                suppliesClient.createSupply(supply);
                FacesContext.getCurrentInstance().getExternalContext().getFlash().put("successMessage", "Supply created successfully!");
            }
            return goBack();
        } catch (IOException | InterruptedException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error saving supply: " + e.getMessage(), null));
            return null;
        }
    }

    public void deleteSupply(int id) {
        try {
            suppliesClient.deleteSupply(id);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("successMessage", "Supply deleted successfully!");
            init(); // Refresh the list
        } catch (IOException | InterruptedException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error deleting supply: " + e.getMessage(), null));
        }
    }

    public String goToCreateForm() {
        supply = new Supplies(); // Initialize a new supply
        isEditing = false; // Set to false for creation
        return "form?faces-redirect=true";
    }

    public String goToEditForm(int id) {
        try {
            supply = suppliesClient.getSupply(id); // Load the supply to edit
            isEditing = true; // Set to true for editing
            return "form?faces-redirect=true";
        } catch (IOException | InterruptedException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error loading supply for editing: " + e.getMessage(), null));
            return null;
        }
    }

    public String goBack() {
        init();
        return "list?faces-redirect=true";
    }
}
