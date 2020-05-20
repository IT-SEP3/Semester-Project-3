package clientNetworking;

import clientNetworking.calendar.CalendarClient;
import clientNetworking.calendar.CalendarClientImpl;
import clientNetworking.login.LoginClient;
import clientNetworking.login.LoginClientImpl;
import clientNetworking.shift.ShiftClient;
import clientNetworking.shift.ShiftClientImpl;

public class ClientFactory {
    private HTTPHandler httpHandler;
    private LoginClient loginClient;
    private CalendarClient calendarClient;
    private ShiftClient shiftClient;


    public ClientFactory(HTTPHandler httpHandler){
        this.httpHandler = httpHandler;
    }

    public LoginClient loginClient() {
        if(loginClient == null)
            loginClient = new LoginClientImpl(httpHandler);
        return loginClient;
    }

    public CalendarClient calendarClient(){
        if(calendarClient == null)
            calendarClient = new CalendarClientImpl(httpHandler);
        return calendarClient;
    }

    public ShiftClient shiftClient(){
        if(shiftClient == null)
            shiftClient = new ShiftClientImpl(httpHandler);
        return shiftClient;
    }
}
