package org.example.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.models.SalesEmployeeRequest;
import org.example.services.SalesEmployeeService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Sales Employee Controller")
@Path("/api/salesemployee")
public class SalesEmployeeController {
    SalesEmployeeService salesEmployeeService;

    public SalesEmployeeController(final SalesEmployeeService salesEmployeeService) {
        this.salesEmployeeService = salesEmployeeService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(
            final SalesEmployeeRequest salesEmployeeRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(salesEmployeeService.createSalesEmployee(
                            salesEmployeeRequest))
                    .build();
        } catch (FailedToCreateException | SQLException e) {
            System.out.println(e);

            return Response.serverError().build();
        } catch (InvalidException e) {
            System.out.println(e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }


}
