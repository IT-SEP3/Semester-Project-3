import java.sql.*;

public class JDBCConnect implements IJDBCConnect {

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/mytest?useTimezone=true&serverTimezone=GMT";
    private final String username = "root";
    private final String password = "9691cmsj";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSetGet;

    public Connection getConnection() {
        try {
            Class.forName(driver);
            System.out.println("Connection to driver established...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Could not get connection to the driver...");
        }
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection to DataBase established...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection to DataBase failed, and was not established...");
        }

        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Disconnected from the DataBase... ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getInformation() {
        try {
            statement = connection.createStatement();
            resultSetGet = statement.executeQuery("SELECT * FROM persona");

            while (resultSetGet.next()) {
                String name = resultSetGet.getString("Name");
                System.out.format("%s\n", name);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void setInformation(String name) {
        String sql = "INSERT INTO persona (Name)" + "VALUES (?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
