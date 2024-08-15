package org.example.services;

import org.example.daos.ClientDao;
import org.example.models.Client;

import java.sql.SQLException;

public class ClientService {
    private final ClientDao clientDao;
    public ClientService(final ClientDao clientDao) {
        this.clientDao = clientDao;
    }
    public Client getClientById(final int id) throws SQLException {
        return clientDao.getClientById(id);
    }
}
