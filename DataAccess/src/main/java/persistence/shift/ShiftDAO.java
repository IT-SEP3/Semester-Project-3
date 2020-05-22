package persistence.shift;

import exceptions.DataConnectionException;
import persistence.database.IDBConnection;
import shared.Shift;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ShiftDAO implements IShiftDAO {

    private final IDBConnection databaseConnection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Shift resultShift = null;

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
                int managerID = resultSet.getInt("Manager_ID");
                int day = resultSet.getInt("day");
                int month = resultSet.getInt("month");
                int year = resultSet.getInt("year");

                String dateString = day + "-" + month + "-" + year;
                System.out.println(dateString);
                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("d-M-yyyy"));;

                shifts.add(new Shift(shift_ID, user_ID, description, managerID, date));
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
        String result = "Success";
        try {

            String sql = "INSERT INTO Shift (Shift_ID, Users_ID, description, Manager_ID, day, month, year) +" +
                    "VALUE('" + shift.getId() + "', '" + shift.getUser_id() + "', '"
                    + shift.getDescription() + "', '" + shift.getManager_id() + "', '"
                    + shift.getDate().getDayOfMonth() + "', '" + shift.getDate().getMonthValue()
                    + "', '" + shift.getDate().getYear() + "')";

            while (resultSet.next()) {
                int shiftId = resultSet.getInt("Shift_ID");
                int userId = resultSet.getInt("Users_ID");
                String description = resultSet.getString("description");
                int managerId = resultSet.getInt("Manager_ID");
                int day = resultSet.getInt("day");
                int month = resultSet.getInt("month");
                int year = resultSet.getInt("year");

                String dateString = day + "-" + month + "-" + year;
                System.out.println(dateString);
                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("d-M-yyyy"));;

                resultShift = new Shift(shiftId, userId, description, managerId,date);
                if (shift.getUser_id() == userId && date == shift.getDate())
                    result = "Failed";
            }

            preparedStatement = databaseConnection.createPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException | DataConnectionException e) {
            e.printStackTrace();
            result = "Failed";
        } finally {
            databaseConnection.closeConnection();
        }
        return result;
    }


}
