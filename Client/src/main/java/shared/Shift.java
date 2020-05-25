package shared;

import java.time.LocalDate;

public class Shift {

    private int id;
    private LocalDate date;
    private int user_id;
    private int manager_id;
    private String description;



    public Shift(int id, int user_id, String description, int manager_id, LocalDate date) {
        this.id = id;
        this.user_id = user_id;
        this.description = description;
        this.manager_id = manager_id;
        this.date = date;
    }

    public Shift(int user_id, String description, int manager_id, LocalDate date) {
        this.user_id = user_id;
        this.description = description;
        this.manager_id = manager_id;
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "id=" + id +
                ", date=" + date +
                ", user_id=" + user_id +
                ", manager_id=" + manager_id +
                ", description='" + description + '\'' +
                '}';
    }
}
