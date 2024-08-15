package org.example.daos;

import org.example.models.DeliveryEmployeeRequest;
import org.example.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeliveryEmployeeDao {


    public List<Employee> getAllDeliverEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, name as `Delivery Employee Name`, "
                            + "salary, bank_acc, ni, type "
                            + "FROM `Employee`;");

            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("Delivery Employee Name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("bank_acc"),
                        resultSet.getString("ni"),
                        resultSet.getInt("type"));


                employees.add(employee);
            }
        }

        return employees;
    }

    public int createDeliveryEmployee(
            final DeliveryEmployeeRequest deliveryEmployeeRequest)
            throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String insertStatement =
                "INSERT INTO `Employee`(name, salary, bank_acc, ni, type)"
                        + "VALUES (?,?,?,?,1);";

        PreparedStatement st = c.prepareStatement(insertStatement,
                Statement.RETURN_GENERATED_KEYS);

        st.setString(1, deliveryEmployeeRequest.getName());
        st.setDouble(2, deliveryEmployeeRequest.getSalary());
        st.setString(1 + 2, deliveryEmployeeRequest.getBankAcc());
        st.setString(2 + 2, deliveryEmployeeRequest.getNi());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return -1;
    }
}
