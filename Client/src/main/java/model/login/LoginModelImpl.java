package model.login;


import clientNetworking.login.LoginClient;
import shared.User;

public class LoginModelImpl implements LoginModel {
    public LoginClient loginClient;
    private User currentUser;

    public LoginModelImpl(LoginClient loginClient) {
        this.loginClient = loginClient;
    }

    @Override
    public void login(String username, String password) {
        User loginCarrier = new User(username,String.valueOf(password.hashCode()));
        String answer = loginClient.login(loginCarrier);
        if(answer.equals("Login successful")){
            currentUser = loginCarrier;
        }
    }

    @Override
    public String loginResponse() {
        return loginClient.getResponse();
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }
}
