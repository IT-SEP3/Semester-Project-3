package clientnetworking;

import shared.Shift;
import shared.User;

public interface Client {
    void Login(User loginCarrier);
    Shift[] getCalendarShifts(String username, String month);
    String getResponse();
}
