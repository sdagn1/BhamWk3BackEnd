package org.example.models;

public class UserResponse {

    private String username;

    public UserResponse(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}
