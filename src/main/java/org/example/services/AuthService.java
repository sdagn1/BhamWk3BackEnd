package org.example.services;

import io.jsonwebtoken.Jwts;
import org.example.daos.AuthDao;
import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.LoginRequest;
import org.example.models.User;
import org.example.validators.AuthValidator;

import java.security.Key;
import java.sql.SQLException;
import java.util.Date;

public class AuthService {
    private final AuthDao authDao;
    private final AuthValidator userValidator;
    private final Key key;
    private final int tokenDuration = 28800000;

    public AuthService(final AuthDao authDao,
                       final AuthValidator userValidator, final Key key) {
        this.authDao = authDao;
        this.userValidator = userValidator;
        this.key = key;
    }

    public String login(final LoginRequest loginRequest)
            throws SQLException, InvalidException {
        userValidator.validateUser(loginRequest);
        User user = authDao.getUser(loginRequest);

        if (user == null) {
            throw new InvalidException(Entity.USER, "Invalid credentials");
        }

        return generateJwtToken(user);
    }

    private String generateJwtToken(final User user) {
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()
                        + tokenDuration))
                .claim("Role", user.getRoleId())
                .subject(user.getUsername())
                .issuer("DropwizardDemo")
                .signWith(key)
                .compact();
    }
}
