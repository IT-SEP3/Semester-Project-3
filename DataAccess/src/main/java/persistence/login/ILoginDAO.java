package persistence.login;

import shared.User;

public interface ILoginDAO {
    String validateLogin(User user) ;

    User getUser(User user);

    int getID(User user);
}
