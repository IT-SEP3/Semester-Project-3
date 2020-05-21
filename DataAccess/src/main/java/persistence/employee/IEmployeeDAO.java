package persistence.employee;

import shared.User;

public interface IEmployeeDAO {
    User getUser(String userId);
}
