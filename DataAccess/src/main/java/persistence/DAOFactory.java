package persistence;

import persistence.database.IDBConnection;
import persistence.login.ILoginDAO;
import persistence.login.LoginDAO;
import persistence.shift.IShiftDAO;
import persistence.shift.ShiftDAO;

public class DAOFactory {
    private ILoginDAO login;
    private IShiftDAO shift;
    private IDBConnection connect;

    public DAOFactory(IDBConnection connect) {
        this.connect = connect;
        login = new LoginDAO(connect);
        shift = new ShiftDAO(connect);
    }

    public ILoginDAO getLogin() {
        return login;
    }

    public IShiftDAO getShift() {
        return shift;
    }
}
