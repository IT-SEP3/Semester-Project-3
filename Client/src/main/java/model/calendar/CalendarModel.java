package model.calendar;

import clientNetworking.calendar.ICalendarClient;
import model.login.ILoginModel;
import shared.Shift;
import shared.User;

import java.util.ArrayList;

public class CalendarModel implements ICalendarModel {
    private ICalendarClient calendarClient;
    private ILoginModel loginModel;
    private User currentUser;
    private ArrayList<Shift> shifts;

    public CalendarModel(ICalendarClient calendarClient, ILoginModel loginModel) {
        this.calendarClient = calendarClient;
        this.loginModel = loginModel;
        shifts = new ArrayList<Shift>();
    }

    @Override
    public void getCalendar(String timeStamp) {
        shifts = calendarClient.getCalendarShifts(loginModel.getCurrentUser().getId(), timeStamp);
    }

    @Override
    public void getUser() {
        currentUser = calendarClient.getUser( Integer.toString(loginModel.getCurrentUser().getId()));
        System.out.println("User recieved"+ currentUser.getAccessLevel());
    }

    @Override
    public Shift getShift(int i) {
        return shifts.get(i);
    }

    public ArrayList<Shift> getShifts() {
        return shifts;
    }
}
