package model;


import clientNetworking.ClientFactory;
import model.calendar.ICalendarModel;
import model.calendar.CalendarModel;
import model.login.ILoginModel;
import model.login.LoginModel;

public class ModelFactory {
    private ClientFactory clientFactory;
    private ILoginModel loginModel;
    private ICalendarModel calendarModel;

    public ModelFactory(ClientFactory c) {
        clientFactory = c;
    }

    public ILoginModel loginModel() {
        if(loginModel == null)
            loginModel = new LoginModel(clientFactory.loginClient());
        return loginModel;
    }

    public ICalendarModel calendarModel() {
        if(calendarModel == null)
            calendarModel = new CalendarModel(clientFactory.calendarClient(), loginModel());
        return calendarModel;
    }
}
