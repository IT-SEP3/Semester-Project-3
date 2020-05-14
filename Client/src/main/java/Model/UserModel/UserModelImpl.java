package Model.UserModel;


import ClientNetworking.Client;
import Shared.User;

public class UserModelImpl implements UserModel{
    public Client client;

    public UserModelImpl(Client client) {
        this.client = client;
    }

    @Override
    public void login(String username, String password) {
        User loginCarrier = new User(username,String.valueOf(password.hashCode()));
        client.Login(loginCarrier);
    }

    @Override
    public String loginResponse() {
        return client.getResponse();
    }
}
