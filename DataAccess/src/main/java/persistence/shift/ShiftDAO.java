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
    public ArrayList<Shift> getShifts(Shift shift, User user) {
        ArrayList<Shift> shifts = new ArrayList<>();

        try {
            String sql = "SELECT * FROM " + databaseConnection.getShiftTable() + " WHERE users_ID = " + user.getId() + ";";
            preparedStatement = databaseConnection.createPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next()) {
                int shiftID = resultSet.getInt("Shift_ID");
                int userID = resultSet.getInt("Users_ID");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int managerID = resultSet.getInt("Manager_ID");
                Date createdAt = resultSet.getTimestamp("createdAt");

                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                String date = dateFormat.format(createdAt);

                shifts.add(new Shift(shiftID, userID, description, status, managerID, date));
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
    }
}
