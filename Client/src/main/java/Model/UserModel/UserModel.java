package Model.UserModel;

import Shared.User;

public interface UserModel {
    void login(String username, String password);
    String loginResponse();
}
