package org.example.daos;

import org.example.models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT name FROM Client;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                clients.add(new Client(
                        resultSet.getString("name"))
                );
            }
        }
        return clients;
    }

    public Client getClientById(final int id)
            throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT name FROM Client WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return new Client(
                        resultSet.getString("name"));
            }
            return null;
        }
    }
}
