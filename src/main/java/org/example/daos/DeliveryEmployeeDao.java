package org.example.daos;

import org.example.models.DeliveryEmployeeRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeliveryEmployeeDao {


    public int createDeliveryEmployee(
            final DeliveryEmployeeRequest deliveryEmployeeRequest)
            throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String insertStatement =
                "INSERT INTO `Employee`(name, salary, bank_acc, ni, type)"
                        + "VALUES (?,?,?,?,?);";

        PreparedStatement st = c.prepareStatement(insertStatement,
                Statement.RETURN_GENERATED_KEYS);

        st.setString(1, deliveryEmployeeRequest.getName());
        st.setDouble(2, deliveryEmployeeRequest.getSalary());
        st.setString(1 + 2, deliveryEmployeeRequest.getBankAcc());
        st.setString(2 + 2, deliveryEmployeeRequest.getNi());
        st.setInt(2 + 2 + 1, deliveryEmployeeRequest.getType());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return -1;
    }
}
