package main.java.persistence.login;

import main.java.exceptions.DataConnectionException;
import main.java.shared.User;

public interface ILoginDAO {
    String validateLogin(User user) throws DataConnectionException;

    User getUser(User user);
}
