package clientNetworking;

import clientNetworking.calendar.ICalendarClient;
import clientNetworking.calendar.CalendarClient;
import clientNetworking.createUser.CreateUserClient;
import clientNetworking.createUser.ICreateUserClient;
import clientNetworking.employeeList.EmployeeListClient;
import clientNetworking.employeeList.IEmployeeListClient;
import clientNetworking.login.ILoginClient;
import clientNetworking.login.LoginClient;
import clientNetworking.shift.IShiftClient;
import clientNetworking.shift.ShiftClient;

public class ClientFactory {
    private HTTPHandler httpHandler;
    private ILoginClient loginClient;
    private ICalendarClient calendarClient;
    private IShiftClient shiftClient;
    private ICreateUserClient createUserClient;
    private IEmployeeListClient employeeListClient;


    public ClientFactory(HTTPHandler httpHandler){
        this.httpHandler = httpHandler;
    }

    public ILoginClient loginClient() {
        if(loginClient == null)
            loginClient = new LoginClient(httpHandler);
        return loginClient;
    }

    public ICalendarClient calendarClient(){
        if(calendarClient == null)
            calendarClient = new CalendarClient(httpHandler);
        return calendarClient;
    }

    public IShiftClient shiftClient(){
        if(shiftClient == null)
            shiftClient = new ShiftClient(httpHandler);
        return shiftClient;
    }

    public ICreateUserClient createUserClient() {
        if (createUserClient == null)
            createUserClient = new CreateUserClient(httpHandler);
        return createUserClient;
    }

    public IEmployeeListClient employeeList() {
        if (employeeListClient == null)
            employeeListClient = new EmployeeListClient(httpHandler);
        return employeeListClient;
    }
}
