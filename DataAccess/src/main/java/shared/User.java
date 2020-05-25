package shared;

import java.time.LocalDate;

public class User {
    private int id;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String email;
    private String status;
    private LocalDate employmentDate;
    private String accessLevel;

    public User(int id, String username, String password, String fname, String lname, String email, String status, LocalDate employmentDate, String accessLevel) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.status = status;
        this.employmentDate = employmentDate;
        this.accessLevel = accessLevel;
    }




    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAccessLevel() {
        return accessLevel;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", employmentDate=" + employmentDate +
                ", accessLevel='" + accessLevel + '\'' +
                '}';
    }
}
