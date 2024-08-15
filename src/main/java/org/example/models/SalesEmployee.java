package org.example.models;

public class SalesEmployee extends Employee { private double commissionRate;

    public SalesEmployee(final int employeeId, final String name,
                         final double salary,
                         final String bankAcc, final String ni,
                         final int type,
                         final double commissionRate) {

        super(employeeId, name, salary, bankAcc, ni, type);
        this.commissionRate = commissionRate;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(final double commissionRate) {
        this.commissionRate = commissionRate;
    }
}
