package persistence.shift;

import exceptions.DataConnectionException;
import persistence.database.IDBConnection;
import persistence.login.LoginDAO;
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
    LoginDAO loginDAO;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    User resultUser = null;
    String conclusion = "NOT";

    public ShiftDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public String retrieveShifts(Shift shift) {

        return null;
    }

    @Override
    public ArrayList<Shift> getShifts(Shift shift) {
        ArrayList<Shift> shifts = new ArrayList<>();

        try {
//            String sql = "SELECT * FROM " + databaseConnection.getShiftTable() + " WHERE users_ID = " + ;
//            preparedStatement = databaseConnection.createPreparedStatement(sql);
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

                shifts.add(new Shift(shiftID, userID, description, status, managerID, createdAt));
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        }

        return shifts;
    }
}
