package org.example.validators;

import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.DeliveryEmployeeRequest;

public class DeliveryEmployeeValidator {

    public void validateDeliveryEmployee(
            final DeliveryEmployeeRequest deliveryEmployeeRequest)
            throws InvalidException {
        final int maxNameLength = 50;
        final double maxSalary = 9999999999.99;
        final int maxBankAccLength = 8;
        final int maxNiLength = 8;

        if (deliveryEmployeeRequest.getName().length() > maxNameLength) {
            throw new InvalidException(Entity.DELIVERYEMPLOYEE,
                    "Name is too long");
        }
        if (deliveryEmployeeRequest.getSalary() > maxSalary) {
            throw new InvalidException(Entity.DELIVERYEMPLOYEE,
                    "Salary is too long");
        }
        if (deliveryEmployeeRequest.getBankAcc().length() > maxBankAccLength) {
            throw new InvalidException(Entity.DELIVERYEMPLOYEE,
                    "Bank Acc is too long");
        }
        if (deliveryEmployeeRequest.getNi().length() > maxNiLength) {
            throw new InvalidException(Entity.DELIVERYEMPLOYEE,
                    "Ni is too long");
        }
//        if (deliveryEmployeeRequest.getType() != 1
//                &&
//                deliveryEmployeeRequest.getType() != 2) {
//            throw new InvalidException(Entity.DELIVERYEMPLOYEE,
//                    "Type is not valid");
//        }
    }
}
