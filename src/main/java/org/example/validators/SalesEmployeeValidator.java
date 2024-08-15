package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.SalesEmployeeRequest;

public class SalesEmployeeValidator {
    private final int nameLength = 50;
    private final int backAccLength = 8;
    private final int niLength = 9;

    public void validateSalesEmployee(
            final SalesEmployeeRequest salesEmployeeRequest)
            throws
            InvalidException {
        if (salesEmployeeRequest.getName().length() > nameLength) {
            throw new InvalidException(Entity.SALESEMPLOYEE,
                    "Name greater than 50 characters");
        }

        if (salesEmployeeRequest.getBankAcc().length() > backAccLength) {
            throw new InvalidException(Entity.SALESEMPLOYEE,
                    "Bank account is more than 8 characters");
        }
        if (salesEmployeeRequest.getNi().length() > niLength) {
            throw new InvalidException(Entity.SALESEMPLOYEE,
                    "Ni is more than 8 characters");
        }
    }
}
