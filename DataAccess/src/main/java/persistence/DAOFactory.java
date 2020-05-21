package persistence;

import persistence.calendar.CalendarDAO;
import persistence.calendar.ICalendarDAO;
import persistence.database.IDBConnection;
import persistence.login.ILoginDAO;
import persistence.login.LoginDAO;
import persistence.shifts.IShiftDAO;
import persistence.shifts.ShiftDAO;

public class DAOFactory {
    private IDBConnection connect;
    private ILoginDAO login;
    private ICalendarDAO calendar;
    private IShiftDAO shift;

    public DAOFactory(IDBConnection connect) {
        this.connect = connect;
    }

    public ILoginDAO getLogin() {
        if(login == null)
            login = new LoginDAO(connect);
        return login;
    }

    public ICalendarDAO getCalendar() {
        if(calendar == null)
            calendar = new CalendarDAO(connect);
        return calendar;
    }

    public IShiftDAO getShift() {
        if(shift == null)
            shift = new ShiftDAO(connect);
        return shift;
    }
}
