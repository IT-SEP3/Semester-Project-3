package persistence.login;

import shared.User;
import exceptions.DataConnectionException;

public interface ILoginDAO {
    String validateLogin(User user) throws DataConnectionException;

    User getUser(User user);
}
