package model.login;


import clientNetworking.login.LoginClient;
import shared.User;

public class LoginModelImpl implements LoginModel {
    public LoginClient loginClient;
    private User currentUser;
    private String response;

    public LoginModelImpl(LoginClient loginClient) {
        this.loginClient = loginClient;
    }

    @Override
    public void login(String username, String password) {
        User loginCarrier = new User(username,String.valueOf(password.hashCode()));
        String answer = loginClient.Login(loginCarrier);
        String[] splitAnswer = answer.split(";");
        if(splitAnswer[0].equals("Login successful")){
            currentUser = loginCarrier;
            response = splitAnswer[0];
            currentUser.setId(Integer.parseInt(splitAnswer[1]));
        }
    }

    @Override
    public String loginResponse() {
        return response;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }
}
