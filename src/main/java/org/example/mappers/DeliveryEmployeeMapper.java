package org.example.mappers;

import org.example.models.DeliveryEmployeeResponse;
import org.example.models.Employee;

import java.util.List;
import java.util.stream.Collectors;

public final class DeliveryEmployeeMapper {

    private DeliveryEmployeeMapper() {
        throw new UnsupportedOperationException("This is a utility class "
                + "and cannot be instantiated");
    }

    public static List<DeliveryEmployeeResponse>
    mapDeliveryEmployeeListToResponseList(
            final List<Employee> employees) {
        return employees
                .stream()
                .map(employee -> new DeliveryEmployeeResponse(employee.getId(),
                        employee.getName(), employee.getSalary()))
                .collect(Collectors.toList());
    }
}
