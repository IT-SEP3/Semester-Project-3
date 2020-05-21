package clientNetworking.calendar;

import shared.Shift;
import shared.User;

import java.util.ArrayList;

public interface CalendarClient {
    ArrayList<Shift> getCalendarShifts(int userId, String month);
    String getResponse();
    User getUser(String currentUser);
}
