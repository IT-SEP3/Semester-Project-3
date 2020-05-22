package model.calendar;

import shared.Shift;

import java.util.ArrayList;

public interface ICalendarModel {
    void getCalendar(String timeStamp);
    void getUser();
    ArrayList<Shift> getShifts();
    Shift getShift(int i);
}
