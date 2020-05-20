package shared;

import java.time.LocalDate;

public class Shift {
    private String date;
    private LocalDate localdate;
    private String title;

    public Shift(String date, String title, LocalDate localdate) {
        this.date = date;
        this.title = title;
        this.localdate = localdate;
    }

    public String getTitle() {
        return title;
    }

    public String getDateString() {
        return date;
    }

    public LocalDate getDate(){
        return localdate;
    }
}
