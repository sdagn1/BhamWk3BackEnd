package org.example.daos;

import org.example.models.Project;
import org.example.models.ProjectRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDao {
    private final int clientNumber = 3;
    public int createProject(final ProjectRequest projectRequest)
            throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String insertStatement =
                    "INSERT INTO Project (name, value, clientID)"
                            +
                            "VALUES (?,?,?)";
            PreparedStatement stmt =
                    connection.prepareStatement(insertStatement,
                            PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, projectRequest.getName());
            stmt.setDouble(2, projectRequest.getValue());
            stmt.setInt(clientNumber, projectRequest.getClientID());
            stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return -1;
        }
    }
    public Project getProjectById(final int id)
            throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT name, value, completed FROM Project"
                    +
                    " WHERE id=?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return new Project(
                        resultSet.getString("name"),
                        resultSet.getDouble("value"));
            }
            return null;
        }
    }

    public void completeProject(final int id)
            throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String updateStatement =
                    "UPDATE Project SET completed=1 "
                            +
                            "WHERE id=?;";
            PreparedStatement stmt =
                    connection.prepareStatement(updateStatement);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
