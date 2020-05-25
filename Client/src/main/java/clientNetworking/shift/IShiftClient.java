package clientNetworking.shift;

import shared.Shift;

import java.util.HashMap;

public interface IShiftClient {
    String postShift(Shift shift);
    String getResponse();
    public HashMap<String, Integer> getUsers();
}
