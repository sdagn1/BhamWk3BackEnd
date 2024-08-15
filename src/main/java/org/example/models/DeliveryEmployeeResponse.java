package org.example.models;

public class DeliveryEmployeeResponse {

    private int id;
    private String name;
    private double salary;

    public DeliveryEmployeeResponse(final int id, final String name,
                                    final double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;

    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
