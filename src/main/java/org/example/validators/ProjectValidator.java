package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.ProjectRequest;
import org.example.services.ClientService;

import java.sql.SQLException;

public class ProjectValidator {
    private ClientService clientService;
    private final int nameLength = 50;
    private final int valueBoundary = 100000000;

    public ProjectValidator(final ClientService clientService) {
        this.clientService = clientService;
    }

    public void validateProjectId(final int id) throws InvalidException {
        if (id <= 0) {
            throw new InvalidException(Entity.PROJECT, "ID is less than 0");
        }
    }

    public void validateProject(final ProjectRequest projectRequest)
            throws InvalidException, SQLException {
        if (projectRequest.getName().length() > nameLength) {
            throw new InvalidException(Entity.PROJECT,
                    "Name is greater than 50 characters.");
        }
        if (projectRequest.getValue() < 0
                ||
                projectRequest.getValue() > valueBoundary) {
            throw new InvalidException(Entity.PROJECT,
                    "Project Value is out of bounds.");
        }

        if (clientService.getClientById(projectRequest.getClientID()) == null) {
            throw new InvalidException(Entity.PROJECT, "Client does not exist");
        }
    }
}
