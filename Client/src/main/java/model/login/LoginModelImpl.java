package model.login;


import clientNetworking.Client;
import shared.User;

public class LoginModelImpl implements LoginModel {
    public Client client;
    private User currentUser;

    public LoginModelImpl(Client client) {
        this.client = client;
    }

    @Override
    public void login(String username, String password) {
        User loginCarrier = new User(username,String.valueOf(password.hashCode()));
        String answer = client.Login(loginCarrier);
        if(answer.equals("Login successful")){
            currentUser = loginCarrier;
        }
    }

    @Override
    public String loginResponse() {
        return client.getResponse();
    }
}
