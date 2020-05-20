package clientNetworking.calendar;

import shared.Shift;
import shared.User;

public interface CalendarClient {
    Shift[] getCalendarShifts(String username, String month);
    String getResponse();
    User getUser(String currentUser);
}
