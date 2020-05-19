package clientNetworking;

import clientNetworking.calendar.CalendarClient;
import clientNetworking.calendar.CalendarClientImpl;
import clientNetworking.login.LoginClient;
import clientNetworking.login.LoginClientImpl;
import clientNetworking.restEASY.HTTPHandler;
import com.google.gson.Gson;
import model.login.LoginModel;
import model.login.LoginModelImpl;

public class ClientFactory {
    private HTTPHandler httpHandler;
    private LoginClient loginClient;
    private CalendarClient calendarClient;


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
}
