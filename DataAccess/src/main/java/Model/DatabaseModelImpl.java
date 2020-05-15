package main.java.Model;

import main.java.Model.DatabaseModel;
import main.java.Shared.Shift;
import main.java.Shared.User;
import main.java.persistence.database.IDBConnection;

public class DatabaseModelImpl implements DatabaseModel {
    private IDBConnection connection;

    public  DatabaseModelImpl(IDBConnection connection){
        this.connection = connection;
    }


    @Override
    public String Login(User login) {
        return null;
    }

    @Override
    public Shift[] getMonthOfShiftsByManager(String recievedPiece, String recievedPiece1) {
        return new Shift[0];
    }
}
