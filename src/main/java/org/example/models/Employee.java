package org.example.models;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String bankAcc;
    private String ni;
    private int type;

    public Employee(final int id, final String name, final double salary,
                    final String bankAcc, final String ni, final int type) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bankAcc = bankAcc;
        this.ni = ni;
        this.type = type;
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

    public String getBankAcc() {
        return bankAcc;
    }

    public void setBankAcc(final String bankAcc) {
        this.bankAcc = bankAcc;
    }

    public String getNi() {
        return ni;
    }

    public void setNi(final String ni) {
        this.ni = ni;
    }

    public int getType() {
        return type;
    }

    public void setType(final int type) {
        this.type = type;
    }
}
