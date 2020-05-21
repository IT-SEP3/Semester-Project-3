package model.calendar;

import clientNetworking.calendar.CalendarClient;
import model.login.LoginModel;
import shared.Shift;
import shared.User;

import java.util.ArrayList;
import java.util.Arrays;

public class CalendarModelImpl implements CalendarModel {
    private CalendarClient calendarClient;
    private LoginModel loginModel;
    private User currentUser;
    private ArrayList<Shift> shifts;

    public CalendarModelImpl(CalendarClient calendarClient, LoginModel loginModel) {
        this.calendarClient = calendarClient;
        this.loginModel = loginModel;
        shifts = new ArrayList<Shift>();
        Shift kaka = new Shift("19-05-2020", "Shift2");
        Shift kaka1 = new Shift("08-05-2020", "Shift3");
        Shift kaka2 = new Shift("03-05-2020", "Shift4");
        Shift kaka3 = new Shift("04-05-2020", "Shift5");
        Shift kaka4 = new Shift("09-05-2020", "Shift6");
        Shift kaka5 = new Shift("23-05-2020", "Shift7");
        Shift kaka6 = new Shift("28-05-2020", "Shift8");
        Shift kaka7 = new Shift("20-05-2020", "Shift9");
        Shift kaka8 = new Shift("12-05-2020", "Shift10");
        Shift kaka9 = new Shift("14-05-2020", "Shift11");
        shifts.add(kaka);
        shifts.add(kaka1);
        shifts.add(kaka2);
        shifts.add(kaka3);
        shifts.add(kaka4);
        shifts.add(kaka5);
        shifts.add(kaka6);
        shifts.add(kaka7);
        shifts.add(kaka8);
        shifts.add(kaka9);


    }

    @Override
    public void getCalendar(String timeStamp) {
        shifts = calendarClient.getCalendarShifts(loginModel.getCurrentUser().getUserName(), timeStamp);
    }

    @Override
    public void getUser() {
        currentUser = calendarClient.getUser( Integer.toString(loginModel.getCurrentUser().getUserId()));
    }

    @Override
    public Shift getShift(int i) {
        return shifts.get(i);
    }

    public ArrayList<Shift> getShifts() {
        return shifts;
    }
}
