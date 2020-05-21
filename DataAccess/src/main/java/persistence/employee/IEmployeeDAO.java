package main.java.persistence.employee;

import shared.User;

public interface IEmployeeDAO {
    String addEmployee(User user);
    User getUser(String userId);
}
