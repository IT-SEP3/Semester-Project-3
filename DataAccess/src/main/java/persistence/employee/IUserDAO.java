package persistence.employee;

import shared.User;

public interface IUserDAO {
    String addUser(User user, String operation);
    User getUser(String userId);
}
