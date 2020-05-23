package persistence.login;

import shared.User;
import exceptions.DataConnectionException;
import persistence.database.IDBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO implements ILoginDAO {

    private final IDBConnection databaseConnection;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    User resultUser = null;
    String conclusion = "NOT";
    int ID;

    public LoginDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public String validateLogin(User user) {
        /*
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User resultUser = null;
        String conclusion = "NOT";
        conclusion= "NOT";

         */
        System.out.println("Trying to login");
        try {
            String sql = "SELECT Users_ID, username, password FROM " + databaseConnection.getSchemaName() + "." + databaseConnection.getUserTable() +
                    " WHERE username LIKE '" + user.getUsername() + "'  AND password LIKE '" + user.getPassword() + "'";
            preparedStatement = databaseConnection.createPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                int id = resultSet.getInt("Users_ID");

                resultUser = new User(userName, password);
                if (resultUser.getPassword().equals(user.getPassword()) && resultUser.getUsername().equals(user.getUsername())) {
                    conclusion = "OK;" + id;
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

    public int getID(User user) {
        try {

            String query = "SELECT Users_ID, username FROM " + databaseConnection.getUserTable() + " WHERE username = " + user.getUsername() + ";";
            preparedStatement = databaseConnection.createPreparedStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Users_ID");

                System.out.println(id);
                ID = id;
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        }
        return ID;
    }
}
