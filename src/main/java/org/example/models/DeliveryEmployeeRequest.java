package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeRequest {
    private String name;
    private double salary;
    private String bankAcc;
    private String ni;
    private int type;

    @JsonCreator
    public DeliveryEmployeeRequest(
            @JsonProperty("name") final String name,
            @JsonProperty("salary") final double salary,
            @JsonProperty("bankAcc") final String bankAcc,
            @JsonProperty("ni") final String ni,
            @JsonProperty("type") final int type) {
        this.name = name;
        this.salary = salary;
        this.bankAcc = bankAcc;
        this.ni = ni;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
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
