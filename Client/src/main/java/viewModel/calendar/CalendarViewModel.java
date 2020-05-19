package viewModel.calendar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.calendar.CalendarModel;
import model.login.LoginModel;

public class CalendarViewModel {
    private CalendarModel model;

    public CalendarViewModel(CalendarModel model) {
        this.model = model;
    }

    public void getCalendar(String timeStamp) {
        model.getCalendar(timeStamp);
    }
}
