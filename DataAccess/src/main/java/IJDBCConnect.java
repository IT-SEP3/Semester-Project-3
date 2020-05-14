


import java.sql.Connection;

public interface IJDBCConnect {
    Connection getConnection();
    void closeConnection();
    void getInformation();
    void setInformation(String name);
}
