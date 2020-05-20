package shared;

public class Shift {
    private String date;
    private String title;

    public Shift(String date, String title) {
        this.date = date;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDateString() {
        return date;
    }
}
