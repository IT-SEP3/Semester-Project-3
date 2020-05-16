package Model;

import Shared.User;
import persistence.database.IDBConnection;

public class DatabaseModelImpl implements DatabaseModel {
    private IDBConnection connection;

    public  DatabaseModelImpl(IDBConnection connection){
        this.connection = connection;
    }

    @Override
    public String Login(User login) {
        System.out.println("Someone is tryingto login");
        return null;
    }
}
