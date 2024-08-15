package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectRequest {
    private String name;
    private double value;
    private int clientID;

    @JsonCreator
    public ProjectRequest(
            @JsonProperty("name") final String name,
            @JsonProperty("value") final double value,
            @JsonProperty("clientID") final int clientID) {
        this.name = name;
        this.value = value;
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(final double value) {
        this.value = value;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(final int clientID) {
        this.clientID = clientID;
    }
}
