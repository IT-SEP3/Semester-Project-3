import exceptions.DataConnectionException;
import persistence.database.DBConnection;
import persistence.database.IDBConnection;
import persistence.login.LoginDAO;
import shared.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RetrieveHashedPassword {

    public static void main(String[] args) {

        String password = "test"; //Write your password here

        System.out.println("\nHashed value of " + "'" + password + "'" + " is: " + password.hashCode());
    }
}
