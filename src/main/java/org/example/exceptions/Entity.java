package org.example.exceptions;

public enum Entity {
    SALESEMPLOYEE("SalesEmployee"),
    PROJECT("Project"),
    USER("User");

    private final String entity;

    Entity(final String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return entity;
    }
}
