package main.java.Model;

import main.java.Model.DatabaseModel;
import main.java.Shared.User;
import main.java.persistence.database.IDBConnection;

public class DatabaseModelImpl implements DatabaseModel {
    private IDBConnection connection;

    public  DatabaseModelImpl(IDBConnection connection){
        this.connection = connection;
    }


    @Override
    public User Login(User login) {
        return null;
    }
}
