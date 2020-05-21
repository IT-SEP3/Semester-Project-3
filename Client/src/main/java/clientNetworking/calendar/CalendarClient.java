package clientNetworking.calendar;

import shared.Shift;

public interface CalendarClient {
    Shift[] getCalendarShifts(String username, String month);

    String getResponse();
}
