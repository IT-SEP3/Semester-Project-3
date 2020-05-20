package model.calendar;

import clientNetworking.calendar.CalendarClient;
import model.login.LoginModel;
import shared.Shift;
import shared.User;

import java.util.ArrayList;

public class CalendarModelImpl implements CalendarModel {
    private CalendarClient calendarClient;
    private LoginModel loginModel;
    private User currentUser;
    private ArrayList<Shift> shifts;

    public CalendarModelImpl(CalendarClient calendarClient, LoginModel loginModel) {
        this.calendarClient = calendarClient;
        this.loginModel = loginModel;
        shifts = new ArrayList<Shift>();
        Shift kaka = new Shift("03-05-2020", "Shift1");
        shifts.add(kaka);
    }

    @Override
    public void getCalendar(String timeStamp) {
        calendarClient.getCalendarShifts(loginModel.getCurrentUser().getUserName(), timeStamp);
    }

    @Override
    public void getUser() {
        currentUser = calendarClient.getUser(loginModel.getCurrentUser().getUserName());
    }

    @Override
    public Shift getShift(int i) {
        return shifts.get(i);
    }
}
