package clientNetworking;

import clientNetworking.calendar.ICalendarClient;
import clientNetworking.calendar.CalendarClient;
import clientNetworking.login.ILoginClient;
import clientNetworking.login.LoginClient;
import clientNetworking.shift.IShiftClient;
import clientNetworking.shift.ShiftClient;

public class ClientFactory {
    private HTTPHandler httpHandler;
    private ILoginClient loginClient;
    private ICalendarClient calendarClient;
    private IShiftClient shiftClient;


    public ClientFactory(HTTPHandler httpHandler){
        this.httpHandler = httpHandler;
    }

    public ILoginClient loginClient() {
        if(loginClient == null)
            loginClient = new LoginClient(httpHandler);
        return loginClient;
    }

    public ICalendarClient calendarClient(){
        if(calendarClient == null)
            calendarClient = new CalendarClient(httpHandler);
        return calendarClient;
    }

    public IShiftClient shiftClient(){
        if(shiftClient == null)
            shiftClient = new ShiftClient(httpHandler);
        return shiftClient;
    }
}
