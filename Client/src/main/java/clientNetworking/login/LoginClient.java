package clientNetworking.login;


import shared.Shift;
import shared.User;

public interface LoginClient {
    String login(User loginCarrier);

    String getResponse();
}
