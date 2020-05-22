package clientNetworking.shift;

import shared.Shift;
import shared.User;

public interface IShiftClient {
    String postShift(Shift shift);
    String getResponse();
}
