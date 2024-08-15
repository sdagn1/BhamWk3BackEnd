package org.example.mappers;

import org.example.models.DeliveryEmployeeResponse;
import org.example.models.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class DeliveryEmployeeMapper {

    public DeliveryEmployeeMapper() {
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
