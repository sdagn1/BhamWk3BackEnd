package org.example.daos;

import org.example.models.SalesEmployeeRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesEmployeeDao {

    public int createSalesEmployee(
            final SalesEmployeeRequest salesEmployeeRequest)
            throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String insertStatement =
                "INSERT INTO Employee (name, salary, bank_acc, ni, type) "
                        + "VALUES (?,?,?,?,2);";

        String insertSalesCommission = "INSERT INTO SalesComm "
                + "(id, commission_rate) VALUES (?,?);";
        System.out.println(salesEmployeeRequest);
        PreparedStatement st = c.prepareStatement(insertStatement,
                PreparedStatement.RETURN_GENERATED_KEYS);

        PreparedStatement salesSt = c.prepareStatement(insertSalesCommission,
                PreparedStatement.RETURN_GENERATED_KEYS);

        st.setString(1, salesEmployeeRequest.getName());
        st.setDouble(2, salesEmployeeRequest.getSalary());
        st.setString(1 + 2, salesEmployeeRequest.getBankAcc());
        st.setString(2 + 2, salesEmployeeRequest.getNi());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            salesSt.setInt(1, rs.getInt(1));
            salesSt.setDouble(2, salesEmployeeRequest.getCommissionRate());
            salesSt.executeUpdate();
            ResultSet rs2 = salesSt.getGeneratedKeys();
            if (rs2.next()) {

                return  rs2.getInt(1);
            }

            return rs.getInt(1);
        }
        return -1;



    }

}
