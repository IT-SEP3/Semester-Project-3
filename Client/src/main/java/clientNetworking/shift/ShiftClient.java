package clientNetworking.shift;

import shared.Shift;
import shared.User;

public interface ShiftClient {
    String postShift(Shift shift);
    String getResponse();
}
