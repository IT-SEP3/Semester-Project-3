package model.createUser;

import clientNetworking.createUser.ICreateUserClient;
import shared.User;

public class CreateUserModel implements ICreateUserModel {

    public ICreateUserClient iCreateUserClient;
    private User userInfo;

    public CreateUserModel(ICreateUserClient iCreateUserClient) {
        this.iCreateUserClient = iCreateUserClient;
    }

    @Override
    public void createUser(String username, String password, String fname, String lname, String email, String status, String accesslevel) {
        User createUserCarrier = new User(username, password, fname, lname, email, status, accesslevel);
        String answer = iCreateUserClient.createUser(createUserCarrier);
        if (answer.equals("OK")) {
            userInfo = createUserCarrier;
        }
    }

    @Override
    public String createUserResponse() {
        return iCreateUserClient.getResponse();
    }

    @Override
    public User getUserInfo() {
        return userInfo;
    }
}
