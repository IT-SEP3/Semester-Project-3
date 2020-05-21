package clientNetworking;

import clientNetworking.addShift.AddShiftClient;
import clientNetworking.calendar.CalendarClient;
import clientNetworking.calendar.CalendarClientImpl;
import clientNetworking.login.LoginClient;
import clientNetworking.login.LoginClientImpl;
import clientNetworking.resteasy.HTTPHandler;

public class ClientFactory {
    private HTTPHandler httpHandler;
    private LoginClient loginClient;
    private CalendarClient calendarClient;
    private AddShiftClient addShiftClient;


    public ClientFactory(HTTPHandler httpHandler) {
        this.httpHandler = httpHandler;
    }

    public LoginClient loginClient() {
        if (loginClient == null)
            loginClient = new LoginClientImpl(httpHandler);
        return loginClient;
    }

    public CalendarClient calendarClient() {
        if (calendarClient == null)
            calendarClient = new CalendarClientImpl(httpHandler);
        return calendarClient;
    }

    public AddShiftClient addShiftClient() {
        if (addShiftClient == null)
            addShiftClient = new clientNetworking.addShift.AddUserClientImpl(httpHandler);
        return addShiftClient;
    }

}
