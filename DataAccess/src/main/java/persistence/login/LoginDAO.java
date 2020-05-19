package persistence.login;

import shared.User;
import exceptions.DataConnectionException;
import persistence.database.IDBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO implements ILoginDAO {

    private final IDBConnection databaseConnection;

    public LoginDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public String validateLogin(User user) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User resultUser = null;
        String conclusion = "NOT";

        try {
            String sql = "SELECT username, password FROM " + databaseConnection.getSchemaName() + "." + databaseConnection.getUserTable() +
                    " WHERE username LIKE '" + user.getUsername() + "'  AND password LIKE '" + user.getPassword() + "'";
            preparedStatement = databaseConnection.createPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");

                resultUser = new User(userName, password);
                if (resultUser.getPassword().equals(user.getPassword()) && resultUser.getUsername().equals(user.getUsername())) {
                    conclusion = "OK";
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DataConnectionException e) {
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
