package main.java.persistence.users;

import exceptions.DataConnectionException;
import persistence.database.IDBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shared.User;

public class UserDAO {

    private final IDBConnection databaseConnection;
    PreparedStatement preparedStatement = null;

    public UserDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public boolean addEmployee(User user) {

        String sql = "INSERT INTO " + databaseConnection.getUserTable() + "(username, password, firstName, lastName, email, status, accessLevel) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getFname() + "', '" + user.getLname() + "', '" + user.getEmail() + "', '" + user.getStatus() + "', '" + user.getAccessLevel() + "')";

        try {
            preparedStatement = databaseConnection.createPreparedStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException | DataConnectionException throwables) {
            throwables.printStackTrace();
            return false;
        }
        finally {
            databaseConnection.closeConnection();
        }
        return true;
    }
}
