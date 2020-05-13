package Model.UserModel;

import Shared.User;

public interface UserModel {
    void login(User loginCarrier);
    String loginResponse();
    String getServerResponse();
}
