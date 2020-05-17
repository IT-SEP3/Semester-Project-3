package persistence.login;

import Shared.User;
import exceptions.DataConnectionException;

public interface ILoginDAO {
    String validateLogin(User user) ;

    User getUser(User user);
}
