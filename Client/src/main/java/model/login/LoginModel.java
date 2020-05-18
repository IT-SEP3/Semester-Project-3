package model.login;

public interface LoginModel {
    void login(String username, String password);
    String loginResponse();
}
