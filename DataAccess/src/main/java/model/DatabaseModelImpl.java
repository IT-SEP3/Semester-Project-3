package model;

import shared.Shift;
import shared.User;
import persistence.database.IDBConnection;

public class DatabaseModelImpl implements DatabaseModel {
    private IDBConnection connection;

    public  DatabaseModelImpl(IDBConnection connection){
        this.connection = connection;
    }

    @Override
    public String Login(User login) {
        System.out.println("Someone is trying to login");
        return null;
    }

    @Override
    public Shift[] getMonthOfShiftsByManager(String username, String date) {

        return new Shift[0];
    }
}
