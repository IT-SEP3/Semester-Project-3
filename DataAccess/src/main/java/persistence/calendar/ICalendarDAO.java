package persistence.calendar;

import shared.Calendar;

public interface ICalendarDAO {

    String validateCalendar (Calendar calendar);

    Calendar getCalendar(Calendar calendar);
}
