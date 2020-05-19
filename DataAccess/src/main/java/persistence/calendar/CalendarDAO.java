package persistence.calendar;

import exceptions.DataConnectionException;
import persistence.database.IDBConnection;
import persistence.login.LoginDAO;
import shared.Calendar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalendarDAO implements ICalendarDAO {

    private final IDBConnection databaseConnection;
    private LoginDAO loginDAO;

    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Calendar resultCalendar = null;
    String conclusion = "NOT";

    public CalendarDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public String validateCalendar(Calendar calendar) {
        try {

            String sql = "SELECT " + loginDAO.getId() + ", month, Id FROM " + databaseConnection.getCalendarTable() +
                    " WHERE user_Id = " + loginDAO.getId() + ";";

            preparedStatement = databaseConnection.createPreparedStatement(sql);
            resultSet= preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userID = resultSet.getInt("user_ID");
                String month = resultSet.getString("month");
                int serial = resultSet.getInt("Id");

                System.out.format("%s, %s, %s\n", userID, month, serial);

                resultCalendar = new Calendar(month);
                if(resultCalendar.getMonth().equals(calendar.getMonth())) {
                    conclusion = "OK";
                }
            }

        } catch (SQLException | DataConnectionException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return conclusion;
    }

    @Override
    public Calendar getCalendar(Calendar calendar) {
        return calendar;
    }
}
