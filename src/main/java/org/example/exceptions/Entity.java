package org.example.exceptions;

public enum Entity {
    SALESEMPLOYEE("SalesEmployee"),
    USER("User"),
    DELIVERYEMPLOYEE("DeliveryEmployee"),
    PROJECT("Project");

    private final String entity;

    Entity(final String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return entity;
    }
}
