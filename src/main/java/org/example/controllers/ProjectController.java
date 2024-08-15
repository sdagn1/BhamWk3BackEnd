package org.example.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.InvalidException;
import org.example.models.ProjectRequest;
import org.example.models.UserRole;
import org.example.services.ProjectService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

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
    @RolesAllowed({UserRole.ADMIN, UserRole.MANAGEMENT})
    @ApiOperation(
            value = "Creates a Project",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = Integer.class)
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

    @PUT
    @Path("/project/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({UserRole.ADMIN, UserRole.MANAGEMENT})
    @ApiOperation(
            value = "Completes a Project",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION))
    public Response completeProject(
            @PathParam("id") final int id) {
        try {
            projectService.completeProject(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.serverError().build();
        } catch (DoesNotExistException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/project")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({UserRole.ADMIN, UserRole.MANAGEMENT})
    @ApiOperation(
            value = "Gets all Projects",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = List.class)
    public Response getProjects() throws SQLException {
        try {
            return Response.ok().entity(projectService.getAllProjects())
                    .build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
