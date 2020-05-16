package ClientNetworking;

import Shared.Shift;
import Shared.User;

public interface Client {
    String Login(User loginCarrier);
    Shift[] getCalendarShifts(String username, String month);
    String getResponse();
}
