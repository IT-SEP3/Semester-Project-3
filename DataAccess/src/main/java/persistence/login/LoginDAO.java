package main.java.persistence.login;

import main.java.persistence.database.IDBConnection;
import main.java.exceptions.DataConnectionException;
import main.java.shared.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO implements ILoginDAO {

    private final IDBConnection databaseConnection;

    public LoginDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public String validateLogin(User user) throws DataConnectionException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User resultUser = null;
        String conclusion = null;

        try {
            String sql = "SELECT username, password " + databaseConnection.getSchemaName() + "." + databaseConnection.getUserTable() +
                    " WHERE username LIKE ' " + user.getUsername() + " AND password LIKE ' " + user.getPassword();
            preparedStatement = databaseConnection.createPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");

                resultUser = new User(userName, password);
                if (resultUser.getPassword().equals(user.getPassword()) && resultUser.getUsername().equals(user.getUsername())) {
                    conclusion = "OK";
                } else
                    conclusion = "NOT";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return conclusion;
    }

    @Override
    public User getUser(User user) {
        return user;
    }
}
