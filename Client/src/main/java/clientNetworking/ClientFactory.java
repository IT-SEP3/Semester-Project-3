package clientNetworking;

import clientNetworking.addUser.AddUserClient;
import clientNetworking.addUser.AddUserClientImpl;
import clientNetworking.calendar.CalendarClient;
import clientNetworking.calendar.CalendarClientImpl;
import clientNetworking.login.LoginClient;
import clientNetworking.login.LoginClientImpl;
import clientNetworking.resteasy.HTTPHandler;

public class ClientFactory {
    private HTTPHandler httpHandler;
    private LoginClient loginClient;
    private CalendarClient calendarClient;
    private AddUserClient addShiftClient;


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

    public AddUserClient addShiftClient() {
        if (addShiftClient == null)
            addShiftClient = new AddUserClientImpl(httpHandler);
        return addShiftClient;
    }

}
