package main.java.model;

import main.java.persistence.database.IDBConnection;
import main.java.shared.User;

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
