package model;


import clientNetworking.ClientFactory;
import model.calendar.CalendarModel;
import model.calendar.CalendarModelImpl;
import model.login.LoginModel;
import model.login.LoginModelImpl;

public class ModelFactory {
    private ClientFactory clientFactory;
    private LoginModel loginModel;
    private CalendarModel calendarModel;

    public ModelFactory(ClientFactory c) {
        clientFactory = c;
    }

    public LoginModel loginModel() {
        if(loginModel == null)
            loginModel = new LoginModelImpl(clientFactory.loginClient());
        return loginModel;
    }

    public CalendarModel calendarModel() {
        if(calendarModel == null)
            calendarModel = new CalendarModelImpl(clientFactory.calendarClient(), loginModel());
        return calendarModel;
    }
}
