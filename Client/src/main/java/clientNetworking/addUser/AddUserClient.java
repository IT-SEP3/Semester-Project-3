package clientNetworking.addUser;

import shared.User;

public interface AddUserClient {
    String AddUser(User user);

    String getResponse();
}
