package org.example.services;

import org.example.daos.ProjectDao;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.Project;
import org.example.models.ProjectRequest;
import org.example.validators.ProjectValidator;

import java.sql.SQLException;

public class ProjectService {

    private ProjectDao projectDao;
    private ProjectValidator projectValidator;

    public ProjectService(final ProjectDao projectDao,
                          final ProjectValidator projectValidator) {
        this.projectDao = projectDao;
        this.projectValidator = projectValidator;
    }

    public int createProject(final ProjectRequest projectRequest)
            throws SQLException, InvalidException {
        projectValidator.validateProject(projectRequest);
        int id = projectDao.createProject(projectRequest);
        if (id == -1) {
            int x = 1;
        }
        return id;
    }

    public void completeProject(final int id)
            throws SQLException, DoesNotExistException {
        Project projectToUpdate = projectDao.getProjectById(id);
        if (projectToUpdate == null) {
            throw new DoesNotExistException(Entity.PROJECT);
        }
        projectDao.completeProject(id);
    }
}
