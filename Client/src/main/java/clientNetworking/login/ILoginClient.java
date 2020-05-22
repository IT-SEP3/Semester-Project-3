package clientNetworking.login;


import shared.Shift;
import shared.User;

public interface ILoginClient {
    String login(User loginCarrier);
    String getResponse();
}
