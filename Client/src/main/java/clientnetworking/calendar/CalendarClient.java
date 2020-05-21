package clientNetworking.calendar;

import shared.Shift;
import shared.User;

import java.util.ArrayList;

public interface CalendarClient {
    ArrayList<Shift> getCalendarShifts(String username, String month);
    String getResponse();
    User getUser(String currentUser);
}
