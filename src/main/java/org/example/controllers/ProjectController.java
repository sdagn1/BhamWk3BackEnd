package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.InvalidException;
import org.example.models.ProjectRequest;
import org.example.services.ProjectService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Project API")
@Path("/api")
public class ProjectController {
    private ProjectService projectService;


    public ProjectController(final ProjectService projectService) {
        this.projectService = projectService;
    }

    @POST
    @Path("/project")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProject(final ProjectRequest projectRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(projectService.createProject(projectRequest))
                    .build();
        } catch (SQLException e) {
            return Response.serverError().build();
        } catch (InvalidException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }
}
