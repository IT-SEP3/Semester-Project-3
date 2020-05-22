package persistence;

import persistence.employee.IEmployeeDAO;
import persistence.database.IDBConnection;
import persistence.employee.EmployeeDAO;
import persistence.login.ILoginDAO;
import persistence.login.LoginDAO;
import persistence.shift.IShiftDAO;
import persistence.shift.ShiftDAO;

public class DAOFactory {

    private IDBConnection connect;
    private ILoginDAO login;
    private IShiftDAO shift;
    private IEmployeeDAO employee;

    public DAOFactory(IDBConnection connect) {
        this.connect = connect;
    }

    public ILoginDAO getLogin() {
        if(login == null)
            login = new LoginDAO(connect);
        return login;
    }

    public IShiftDAO getShift() {
        if(shift == null)
            shift = new ShiftDAO(connect);
        return shift;
    }

    public IEmployeeDAO getEmployee() {
        if(employee == null)
            employee = new EmployeeDAO(connect);
        return employee;
    }
}
