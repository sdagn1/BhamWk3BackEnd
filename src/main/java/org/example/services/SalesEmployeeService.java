package org.example.services;

import org.example.daos.SalesEmployeeDao;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.models.SalesEmployeeRequest;
import org.example.validators.SalesEmployeeValidator;


import java.sql.SQLException;

public class SalesEmployeeService {
    SalesEmployeeDao salesEmployeeDao;
    SalesEmployeeValidator salesEmployeeValidator;



    public SalesEmployeeService(final SalesEmployeeDao salesEmployeeDao,
                                final SalesEmployeeValidator salesEmployeeValidator) {
        this.salesEmployeeDao = salesEmployeeDao;
        this.salesEmployeeValidator = salesEmployeeValidator;
    }

    public int createSalesEmployee(
            final SalesEmployeeRequest salesEmployeeRequest)
            throws SQLException, FailedToCreateException, InvalidException {
        salesEmployeeValidator.validateSalesEmployee(salesEmployeeRequest);

        int id = salesEmployeeDao.createSalesEmployee(salesEmployeeRequest);

        if (id == -1) {
            throw new FailedToCreateException(Entity.SALESEMPLOYEE);
        }
        return id;

    }


}
