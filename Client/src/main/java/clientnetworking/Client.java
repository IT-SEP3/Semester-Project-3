package clientNetworking;


import shared.Shift;
import shared.User;

public interface Client {
    String Login(User loginCarrier);
    Shift[] getCalendarShifts(String username, String month);
    String getResponse();
}
