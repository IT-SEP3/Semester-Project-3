package clientNetworking.addUser;

import shared.Shift;
import shared.User;


public interface AddUserClient {
    String AddUser(User user);

    String getResponse();
}
