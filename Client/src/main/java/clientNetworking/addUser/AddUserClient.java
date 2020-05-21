package clientNetworking.addUser;

import shared.Shift;
import shared.User;


public interface AddUserClient {
    String addUser(User user);

    String getResponse();
}
