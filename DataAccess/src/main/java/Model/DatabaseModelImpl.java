package Model;

import Shared.Shift;
import Shared.User;
import exceptions.DataConnectionException;
import persistence.database.IDBConnection;
import persistence.login.ILoginDAO;

public class DatabaseModelImpl implements DatabaseModel {
    private ILoginDAO loginDAO;
    public  DatabaseModelImpl(ILoginDAO loginDAO){
        this.loginDAO = loginDAO;
    }

    @Override
    public String Login(User login) {
        System.out.println("Someone is trying to login");
        String fromDatabase = loginDAO.validateLogin(login);
        return fromDatabase;
    }

    @Override
    public Shift[] getMonthOfShiftsByManager(String username, String date) {

        return new Shift[0];
    }
}
