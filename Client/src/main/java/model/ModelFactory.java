package model;


import clientNetworking.Client;
import model.login.LoginModel;
import model.login.LoginModelImpl;

public class ModelFactory {
    private Client client;
    private LoginModel loginModel;

    public ModelFactory(Client c) {
        client = c;
    }

    public LoginModel userModel() {
        if(loginModel == null)
            loginModel = new LoginModelImpl(client);
        return loginModel;
    }
}
