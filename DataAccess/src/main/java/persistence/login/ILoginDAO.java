package main.java.persistence.login;


import main.java.Exceptions.DataConnectionException;
import main.java.Shared.User;

public interface ILoginDAO {
    String validateLogin(User user) throws DataConnectionException;

    User getUser(User user);
}
