package model.createUser;

import clientNetworking.createUser.ICreateUserClient;
import shared.User;

public class CreateUserModel implements ICreateUserModel {

    private ICreateUserClient iCreateUserClient;
    private String response;
    private User userInfo;

    public CreateUserModel(ICreateUserClient iCreateUserClient) {
        this.iCreateUserClient = iCreateUserClient;
    }

    @Override
    public String createUser(String username, String password, String fname, String lname, String email, String status, String accesslevel) {
        User createUserCarrier = new User(username, password, fname, lname, email, status, accesslevel);
        String answer = iCreateUserClient.createUser(createUserCarrier);
        System.out.println(answer);
        return answer;
    }

    @Override
    public User getUserInfo() {
        return userInfo;
    }
}
