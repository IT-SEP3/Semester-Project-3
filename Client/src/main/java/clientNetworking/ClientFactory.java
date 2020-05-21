package clientNetworking;

import clientNetworking.addShift.AddShiftClient;
import clientNetworking.addShift.AddShiftClientImpl;
import clientNetworking.addUser.AddUserClient;
import clientNetworking.addUser.AddUserClientImpl;
import clientNetworking.calendar.CalendarClient;
import clientNetworking.calendar.CalendarClientImpl;
import clientNetworking.login.LoginClient;
import clientNetworking.login.LoginClientImpl;
import clientNetworking.resteasy.HTTPHandler;
import com.google.gson.Gson;
import model.login.LoginModel;
import model.login.LoginModelImpl;
import shared.User;

public class ClientFactory {
    private HTTPHandler httpHandler;
    private LoginClient loginClient;
    private CalendarClient calendarClient;
    private AddShiftClient addShiftClient;
    private AddUserClient addUserClient;

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
            addShiftClient = new AddShiftClientImpl(httpHandler);
        return addShiftClient;
    }

    public AddUserClient addUserClient() {
        if (addUserClient == null)
            addUserClient = new AddUserClientImpl(httpHandler);
        return addUserClient;
    }
}
