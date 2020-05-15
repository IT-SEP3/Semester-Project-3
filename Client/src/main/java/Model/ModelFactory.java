package Model;


import ClientNetworking.Client;
import Model.UserModel.UserModel;
import Model.UserModel.UserModelImpl;

public class ModelFactory {
    private Client client;
    private UserModel userModel;

    public ModelFactory(Client c) {
        client = c;
    }

    public UserModel userModel() {
        if(userModel == null)
            userModel = new UserModelImpl(client);
        return userModel;
    }
}
