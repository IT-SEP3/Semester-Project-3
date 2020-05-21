package clientNetworking.addShift;

import shared.Shift;


public interface AddShiftClient {
    String AddShift(Shift shift);

    String getResponse();
}
