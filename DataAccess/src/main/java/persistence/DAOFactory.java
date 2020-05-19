package persistence;

import persistence.database.IDBConnection;
import persistence.login.ILoginDAO;
import persistence.login.LoginDAO;

public class DAOFactory {
    private ILoginDAO login;
    private IDBConnection connect;

    public DAOFactory(IDBConnection connect) {
        this.connect = connect;
        login = new LoginDAO(connect);
    }

    public ILoginDAO getLogin() {
        return login;
    }
}
