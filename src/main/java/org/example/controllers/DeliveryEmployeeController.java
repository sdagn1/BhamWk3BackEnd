package org.example.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.models.DeliveryEmployeeRequest;
import org.example.models.Employee;
import org.example.models.UserRole;
import org.example.services.DeliveryEmployeeService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Engineering Academy Wk3 DeliveryEmployee API")
@Path("/api/deliveryEmployee")
public class DeliveryEmployeeController {
    DeliveryEmployeeService deliveryEmployeeService;
    public DeliveryEmployeeController(final DeliveryEmployeeService
                                              deliveryEmployeeService) {
        this.deliveryEmployeeService = deliveryEmployeeService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({UserRole.ADMIN, UserRole.HR})
    @ApiOperation(
            value = "Creates a Delivery Employee",
            authorizations = @Authorization(value = HttpHeaders.AUTHORIZATION),
            response = Employee.class
    )
    public Response createDeliveryEmployee(
            final DeliveryEmployeeRequest deliveryEmployeeRequest) {
        try {
            System.out.println(deliveryEmployeeRequest);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(deliveryEmployeeService.
                            createDeliveryEmployee(deliveryEmployeeRequest))
                    .build();
        } catch (SQLException | FailedToCreateException e) {
            return Response.serverError().build();
        } catch (InvalidException | DoesNotExistException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }

    }
}
