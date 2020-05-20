package model.calendar;

import shared.Shift;

public interface CalendarModel {
    void getCalendar(String timeStamp);

    void getUser();

    Shift getShift(int i);
}
