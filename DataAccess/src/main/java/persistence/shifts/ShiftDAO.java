package persistence.shifts;

import exceptions.DataConnectionException;
import persistence.database.IDBConnection;
import shared.Shift;
import shared.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShiftDAO implements IShiftDAO{
    private final IDBConnection databaseConnection;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public ShiftDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public String postShift(Shift shift) {

        try {
            String sql = "INSERT INTO Users (username, password, firstName, lastName, email, status, accessLevel) +" +
                    "VALUE('"+ shift.get +"', '"+  +"', '"+  +"', '"+  +"', '"+  +"', '"+  +"', '"+  +"')";
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
