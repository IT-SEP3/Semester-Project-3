package ClientNetworking;

import Shared.User;

public interface Client {
    void Login(User loginCarrier);

    String getResponse();
}
