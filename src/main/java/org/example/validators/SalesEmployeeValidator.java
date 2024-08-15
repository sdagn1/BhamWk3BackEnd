package org.example.validators;

import org.example.daos.SalesEmployeeDao;
import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.SalesEmployeeRequest;

public class SalesEmployeeValidator {
    private final int num = 50;
    private final int num2= 8;

    public void validateSalesEmployee(final SalesEmployeeRequest salesEmployeeRequest)
            throws
            InvalidException {
        if (salesEmployeeRequest.getName().length() > num) {
            throw new InvalidException(Entity.SALESEMPLOYEE,
                    "Name greater than 50 characters");
        }

        if (salesEmployeeRequest.getBankAcc().length() > num2) {
            throw new InvalidException(Entity.SALESEMPLOYEE,
                    "Bank account is more than 8 characters");
        }
        if (salesEmployeeRequest.getNi().length() > num2) {
            throw new InvalidException(Entity.SALESEMPLOYEE,
                    "Ni is more than 8 characters");
        }
    }
}
