package clientNetworking.login;


import shared.Shift;
import shared.User;

public interface LoginClient {
    String Login(User loginCarrier);
    String getResponse();
}
