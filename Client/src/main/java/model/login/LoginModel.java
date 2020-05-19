package model.login;

import shared.User;

public interface LoginModel {
    void login(String username, String password);
    String loginResponse();
    User getCurrentUser();
}
