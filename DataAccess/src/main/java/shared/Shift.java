package shared;

import java.util.Date;

public class Shift {

    private int id;
    private int user_id;
    private String description;
    private String status;
    private int manager_id;
    private Date createdAt;

    public Shift(int id, int user_id, String description, String status, int manager_id, Date createdAt) {
        this.id = id;
        this.user_id = user_id;
        this.description = description;
        this.status = status;
        this.manager_id = manager_id;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", manager_id=" + manager_id +
                '}';
    }
}
