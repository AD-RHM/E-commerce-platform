package Entities;

public enum OrderStatus {
    Processing("Processing"), Shipped("Shipped"), Delivered("Delivered"), Cancelled("Cancelled");

    private final String nom;

    OrderStatus(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
