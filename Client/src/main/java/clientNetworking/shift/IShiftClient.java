package clientNetworking.shift;

import shared.Shift;
import shared.User;

import java.util.ArrayList;

public interface IShiftClient {
    String postShift(Shift shift);
    String getResponse();
    ArrayList<User> getUsers(int managerId);
}
