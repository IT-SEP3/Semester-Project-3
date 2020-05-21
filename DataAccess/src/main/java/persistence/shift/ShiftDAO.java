package persistence.shift;

import exceptions.DataConnectionException;
import persistence.database.IDBConnection;
import shared.Shift;
import shared.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class ShiftDAO implements IShiftDAO {

    private final IDBConnection databaseConnection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public ShiftDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public ArrayList<Shift> getShifts(String userID, String monthRequest, String yearRequest) {
        ArrayList<Shift> shifts = new ArrayList<>();

        try {
            String sql = "SELECT * FROM " + databaseConnection.getShiftTable() + " WHERE users_ID = " + Integer.parseInt(userID) + " AND month = " + Integer.parseInt(monthRequest) + " AND year = " + Integer.parseInt(yearRequest) + ";";
            preparedStatement = databaseConnection.createPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next()) {
                int shift_ID = resultSet.getInt("Shift_ID");
                int user_ID = resultSet.getInt("Users_ID");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int managerID = resultSet.getInt("Manager_ID");
                int day = resultSet.getInt("day");
                int month = resultSet.getInt("month");
                int year = resultSet.getInt("year");

                String dateString = day + "-" + month + "-" + year;
                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));;

                shifts.add(new Shift(shift_ID, user_ID, description, status, managerID, date));
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return shifts;
    }

    @Override
    public String postShift(Shift shift) {
/*
        try {
            String sql = "INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel) +" +
                    "VALUE('"+ shift.getId() +"', '"+ shift.getUser_id() +"', '"+ shift.getDescription() +"', '"+ shift.ge +"', '"+  +"', '"+  +"', '"+  +"')";
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
         */
        return null;
    }


}
