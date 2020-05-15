package main.java.Model;

import main.java.Model.DatabaseModel;

public class DatabaseModelImpl implements DatabaseModel {
    private IJDBCConnect connection;

    public  DatabaseModelImpl(IJDBCConnect connection){
        this.connection = connection;
    }

    @Override
    public User Login(User login) {
        return null;
    }
}
