package org.example.services;

import org.example.daos.DeliveryEmployeeDao;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.mappers.DeliveryEmployeeMapper;
import org.example.models.DeliveryEmployeeRequest;
import org.example.models.DeliveryEmployeeResponse;
import org.example.validators.DeliveryEmployeeValidator;

import java.sql.SQLException;
import java.util.List;

public class DeliveryEmployeeService {

    DeliveryEmployeeDao deliveryEmployeeDao;
    DeliveryEmployeeValidator deliveryEmployeeValidator;

    public DeliveryEmployeeService(final
                                   DeliveryEmployeeDao deliveryEmployeeDao,
                                   final
                                   DeliveryEmployeeValidator
                                           deliveryEmployeeValidator) {
        this.deliveryEmployeeDao = deliveryEmployeeDao;
        this.deliveryEmployeeValidator = deliveryEmployeeValidator;
    }


    public List<DeliveryEmployeeResponse> getAllDeliveryEmployees()
            throws SQLException, DoesNotExistException {
        List<DeliveryEmployeeResponse> deliveryEmployeeResponses =
                DeliveryEmployeeMapper.mapDeliveryEmployeeListToResponseList(
                        deliveryEmployeeDao.getAllDeliverEmployees());

        if (deliveryEmployeeResponses.isEmpty()) {
            throw new DoesNotExistException(Entity.DELIVERYEMPLOYEE);
        }

        return deliveryEmployeeResponses;
    }

    public int createDeliveryEmployee(final
                           DeliveryEmployeeRequest deliveryEmployeeRequest)
            throws SQLException, FailedToCreateException, InvalidException,
            DoesNotExistException {
        System.out.println("Test1");

        deliveryEmployeeValidator.validateDeliveryEmployee(
                deliveryEmployeeRequest);

        int id = deliveryEmployeeDao.
                createDeliveryEmployee(deliveryEmployeeRequest);
        System.out.println(id);
        if (id == -1) {
            throw new FailedToCreateException(Entity.DELIVERYEMPLOYEE);
        }
        return id;
    }
}
