package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.LoginRequest;

import java.sql.SQLException;

public class AuthValidator {
    private final int usernameLength = 64;
    private final int passwordLength = 64;

    public void validateUser(final LoginRequest loginRequest)
            throws InvalidException, SQLException {
        if (loginRequest.getUsername().length() > usernameLength) {
            throw new InvalidException(Entity.USER,
                    "Username is greater than 64 characters");
        }

        if (loginRequest.getPassword().length() > passwordLength) {
            throw new InvalidException(Entity.USER,
                    "Password is greater than 64 characters.");
        }
    }
}
