package model.calendar;

import clientNetworking.calendar.CalendarClient;
import model.login.LoginModel;
import shared.Shift;

import java.util.ArrayList;

public class CalendarModelImpl implements CalendarModel {
    private CalendarClient calendarClient;
    private LoginModel loginModel;
    private ArrayList<Shift> shifts;

    public CalendarModelImpl(CalendarClient calendarClient, LoginModel loginModel) {
        this.calendarClient = calendarClient;
        this.loginModel = loginModel;
    }

    @Override
    public void getCalendar(String timeStamp) {
        calendarClient.getCalendarShifts(loginModel.getCurrentUser().getUserName(), timeStamp);
    }
}
