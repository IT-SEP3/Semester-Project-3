package persistence.employee;

import exceptions.DataConnectionException;
import main.java.persistence.employee.IEmployeeDAO;
import persistence.database.IDBConnection;
import shared.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeDAO implements IEmployeeDAO {
    private final IDBConnection databaseConnection;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    User resultUser = null;
    String conclusion = "NOT";

    public EmployeeDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public String addEmployee(User user) {

        String sql = "INSERT INTO " + databaseConnection.getUserTable() + "(username, password, firstName, lastName, email, status, accessLevel) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getFname() + "', '" + user.getLname() + "', '" + user.getEmail() + "', '" + user.getStatus() + "', '" + user.getAccessLevel() + "')";

        try {
            preparedStatement = databaseConnection.createPreparedStatement(sql);
            preparedStatement.executeUpdate();
            return "User '" + user.getUsername() + "' succesfully added";
        } catch (SQLException | DataConnectionException throwables) {
            throwables.printStackTrace();
        }
        finally {
            databaseConnection.closeConnection();
        }
        return null;
    }

    @Override
    public User getUser(String userId) {
        User user = null;
        try{
            String sql = "SELECT * FROM " + databaseConnection.getUserTable() + " WHERE users_ID = " + Integer.parseInt(userId) + ";";
            preparedStatement = databaseConnection.createPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next()) {
                int id = resultSet.getInt("users_ID");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("firstName");
                String lastname = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String status = resultSet.getString("status");
                int day = resultSet.getInt("dayEmployment");
                int month = resultSet.getInt("monthEmployment");
                int year = resultSet.getInt("yearEmployment");
                String accessLevel = resultSet.getString("accessLevel");


                String dateString = day + "-" + month + "-" + year;
                System.out.println(dateString);
                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-M-yyyy"));;
                user = new User(id,  username,  password,  name,  lastname,  email,  status,  date,  accessLevel);
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return user;
    }
}
