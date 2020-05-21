package shared;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Shift {
    private LocalDate date;
    private String title;

    public Shift(String date, String title) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate(){
        return date;
    }
}
