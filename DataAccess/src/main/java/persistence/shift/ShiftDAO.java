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

    public ShiftDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    //CHANGES FROM ANDERS BRANCH
    @Override
    public ArrayList<Shift> getShifts(String userID, String monthRequest, String yearRequest) {
        ArrayList<Shift> shifts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + databaseConnection.getShiftTable() + " WHERE users_ID = " + Integer.parseInt(userID) + " AND month = " + Integer.parseInt(monthRequest) + " AND year = " + Integer.parseInt(yearRequest) + ";";
            PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while ( resultSet.next()) {
                int shift_ID = resultSet.getInt("Shift_ID");
                int user_ID = resultSet.getInt("Users_ID");
                String description = resultSet.getString("description");
                //String status = resultSet.getString("status");
                int managerID = resultSet.getInt("Manager_ID");
                int day = resultSet.getInt("day");
                int month = resultSet.getInt("month");
                int year = resultSet.getInt("year");

                //DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                //String date = dateFormat.format();

                String dateString = day + "-" + month + "-" + year;
                System.out.println(dateString);
                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("d-M-yyyy"));;

                //shifts.add(new Shift(shift_ID, user_ID, description, status, managerID, date));
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
    public ArrayList<Shift> getShiftsManager(String managerID, String monthRequest, String yearRequest) {
        ArrayList<Shift> shifts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + databaseConnection.getShiftTable() + " WHERE Manager_ID = " + Integer.parseInt(managerID) + " AND month = " + Integer.parseInt(monthRequest) + " AND year = " + Integer.parseInt(yearRequest) + ";";
            PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while ( resultSet.next()) {
                int shift_ID = resultSet.getInt("Shift_ID");
                int user_ID = resultSet.getInt("Users_ID");
                String description = resultSet.getString("description");
                int manager_ID = resultSet.getInt("Manager_ID");
                int day = resultSet.getInt("day");
                int month = resultSet.getInt("month");
                int year = resultSet.getInt("year");

                String dateString = day + "-" + month + "-" + year;
                System.out.println(dateString);
                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("d-M-yyyy"));;

                shifts.add(new Shift(shift_ID, user_ID, description, manager_ID, date));
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return shifts;
    }

    @Override
    public String postShift(Shift shift, String operation) {
        if(operation.equals("Check")){
            try {
                String sql = "SELECT Users_ID, Manager_ID, description, day, month, year FROM "
                        + databaseConnection.getShiftTable() + " WHERE Manager_ID = " + shift.getManager_id() +" AND Users_ID = "+ shift.getUser_id() + "AND description = '" + shift.getDescription() +"';";
                PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    databaseConnection.closeConnection();
                    return "NOT";
                } else{
                    databaseConnection.closeConnection();
                    return "YES";
                }
            } catch (DataConnectionException| SQLException e) {
                e.printStackTrace();
                System.out.println("Problem in database");
                databaseConnection.closeConnection();
                return "NOT";
            }

        } else {
            try {
                String sql = "INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year) +" +
                        "VALUE('" + shift.getUser_id() + "', '" + shift.getManager_id() + "','"
                        + shift.getDescription() + "', '" + shift.getDate().getDayOfMonth()
                        + "', '" + shift.getDate().getMonthValue()
                        + "', '" + shift.getDate().getYear() + "')";
                PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
                preparedStatement.executeQuery();
                databaseConnection.closeConnection();
                return "OK";
            } catch (DataConnectionException | SQLException e) {
                e.printStackTrace();
                System.out.println();
                databaseConnection.closeConnection();
                return "NOT";
            }
        }
    }
}
