package shared;

public class User {

    private String userName;
    private String password;
    private int ID;

    public User(String userName, String password, int ID) {
        this.userName = userName;
        this.password = password;
        this.ID = ID;
    }
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
