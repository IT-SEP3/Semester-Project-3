package main.java.persistence.users;

import exceptions.DataConnectionException;
import persistence.database.IDBConnection;
import shared.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO implements IUserDAO {

    private final IDBConnection databaseConnection;
    PreparedStatement preparedStatement = null;

    public UserDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public String addEmployee(User user) {

        String sql = "INSERT INTO " + databaseConnection.getUserTable() + "(username, password, firstName, lastName, email, status, accessLevel) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getFname() + "', '" + user.getLname() + "', '" + user.getEmail() + "', '" + user.getStatus() + "', '" + user.getAccessLevel() + "')";

        try {
            preparedStatement = databaseConnection.createPreparedStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException | DataConnectionException throwables) {
            throwables.printStackTrace();
            return "User '" + user.getUsername() + "' succesfully added";
        }
        finally {
            databaseConnection.closeConnection();
        }
        return null;
    }
}
