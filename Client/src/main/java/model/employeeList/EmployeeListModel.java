package model.employeeList;

import clientNetworking.employeeList.EmployeeListClient;
import clientNetworking.employeeList.IEmployeeListClient;
import clientNetworking.shift.IShiftClient;
import model.calendar.CalendarModel;
import model.calendar.ICalendarModel;
import shared.User;

import java.util.ArrayList;

public class EmployeeListModel implements IEmployeeListModel {
    private IEmployeeListClient employeeListClient;
    private ICalendarModel calendarModel;

    public EmployeeListModel(ICalendarModel calendarModel, IEmployeeListClient employeeListClient) {
        this.employeeListClient = employeeListClient;
        this.calendarModel = calendarModel;
    }

    @Override
    public ArrayList<String> getEmployees() {
        ArrayList<User> users = employeeListClient.getEmployees(calendarModel.getUserFromModel().getId());
        ArrayList<String> usersStrings = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            usersStrings.add(users.get(i).toString());
        }
        return usersStrings;
    }
}
