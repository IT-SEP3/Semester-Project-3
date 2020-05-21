package viewModel.calendar;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.calendar.CalendarModel;
import model.login.LoginModel;
import shared.Shift;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CalendarViewModel {

    private CalendarModel model;
    private StringProperty date1x1 , date1x2, date1x3, date1x4, date1x5, date1x6, date1x7,
            date2x1, date2x2, date2x3, date2x4, date2x5, date2x6, date2x7,
            date3x1, date3x2, date3x3, date3x4, date3x5, date3x6, date3x7,
            date4x1, date4x2, date4x3, date4x4, date4x5, date4x6, date4x7,
            date5x1, date5x2, date5x3, date5x4, date5x5, date5x6, date5x7,
            date6x1, date6x2, date6x3, date6x4, date6x5, date6x6, date6x7;
    private ArrayList<StringProperty> dates;

    public CalendarViewModel(CalendarModel model) {
        this.model = model;
        dates = new ArrayList<StringProperty>();
        date1x1 = new SimpleStringProperty();
        date1x2 = new SimpleStringProperty();
        date1x3 = new SimpleStringProperty();
        date1x4 = new SimpleStringProperty();
        date1x5 = new SimpleStringProperty();
        date1x6 = new SimpleStringProperty();
        date1x7 = new SimpleStringProperty();
        date2x1 = new SimpleStringProperty();
        date2x2 = new SimpleStringProperty();
        date2x3 = new SimpleStringProperty();
        date2x4 = new SimpleStringProperty();
        date2x5 = new SimpleStringProperty();
        date2x6 = new SimpleStringProperty();
        date2x7 = new SimpleStringProperty();
        date3x1 = new SimpleStringProperty();
        date3x2 = new SimpleStringProperty();
        date3x3 = new SimpleStringProperty();
        date3x4 = new SimpleStringProperty();
        date3x5 = new SimpleStringProperty();
        date3x6 = new SimpleStringProperty();
        date3x7 = new SimpleStringProperty();
        date4x1 = new SimpleStringProperty();
        date4x2 = new SimpleStringProperty();
        date4x3 = new SimpleStringProperty();
        date4x4 = new SimpleStringProperty();
        date4x5 = new SimpleStringProperty();
        date4x6 = new SimpleStringProperty();
        date4x7 = new SimpleStringProperty();
        date5x1 = new SimpleStringProperty();
        date5x2 = new SimpleStringProperty();
        date5x3 = new SimpleStringProperty();
        date5x4 = new SimpleStringProperty();
        date5x5 = new SimpleStringProperty();
        date5x6 = new SimpleStringProperty();
        date5x7 = new SimpleStringProperty();
        date6x1 = new SimpleStringProperty();
        date6x2 = new SimpleStringProperty();
        date6x3 = new SimpleStringProperty();
        date6x4 = new SimpleStringProperty();
        date6x5 = new SimpleStringProperty();
        date6x6 = new SimpleStringProperty();
        date6x7 = new SimpleStringProperty();
        dates.add(date1x1);
        dates.add(date1x2);
        dates.add(date1x3);
        dates.add(date1x4);
        dates.add(date1x5);
        dates.add(date1x6);
        dates.add(date1x7);
        dates.add(date2x1);
        dates.add(date2x2);
        dates.add(date2x3);
        dates.add(date2x4);
        dates.add(date2x5);
        dates.add(date2x6);
        dates.add(date2x7);
        dates.add(date3x1);
        dates.add(date3x2);
        dates.add(date3x3);
        dates.add(date3x4);
        dates.add(date3x5);
        dates.add(date3x6);
        dates.add(date3x7);
        dates.add(date4x1);
        dates.add(date4x2);
        dates.add(date4x3);
        dates.add(date4x4);
        dates.add(date4x5);
        dates.add(date4x6);
        dates.add(date4x7);
        dates.add(date5x1);
        dates.add(date5x2);
        dates.add(date5x3);
        dates.add(date5x4);
        dates.add(date5x5);
        dates.add(date5x6);
        dates.add(date5x7);
        dates.add(date6x1);
        dates.add(date6x2);
        dates.add(date6x3);
        dates.add(date6x4);
        dates.add(date6x5);
        dates.add(date6x6);
        dates.add(date6x7);
    }

    public void getCalendar(String timeStamp) {
        model.getCalendar(timeStamp);
    }

    public void getUser() {
        model.getUser();
    }

    public void setCalendar(int month, int year) {
        String firstDayOfMonthTest="";
        try {
            firstDayOfMonthTest= "01-"+ month + "-" + year;
        } catch (IndexOutOfBoundsException e){
            System.out.println("No shifts in that month");
        }
        String finalDay = "default";
        try {
            SimpleDateFormat format1=new SimpleDateFormat("d-M-yyyy");
            Date dt1 = format1.parse(firstDayOfMonthTest);
            DateFormat format2=new SimpleDateFormat("EEEE");
            finalDay = format2.format(dt1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int dayOfweekCounter;
        switch (finalDay) {
            case "Monday":
                dayOfweekCounter = 0;
                break;
            case "Tuesday":
                dayOfweekCounter = 1;
                break;
            case "Wednesday":
                dayOfweekCounter = 2;
                break;
            case "Thursday":
                dayOfweekCounter = 3;
                break;
            case "Friday":
                dayOfweekCounter = 4;
                break;
            case "Saturday":
                dayOfweekCounter = 5;
                break;
            case "Sunday":
                dayOfweekCounter = 6;
                break;
            default:
                dayOfweekCounter = 0;
                break;
        }
        LocalDate convertedDate = LocalDate.parse(firstDayOfMonthTest, DateTimeFormatter.ofPattern("d-M-yyyy"));
        int maxMonthDay = convertedDate.getMonth().length(convertedDate.isLeapYear());
        for (int i = 1; i < maxMonthDay+1; i++) {
            dates.get(dayOfweekCounter+ i-1).set(i+"");
        }

        for (int i = 0; i < model.getShifts().size(); i++) {
            int dayMonth = model.getShift(i).getDate().getDayOfMonth();
            dates.get(dayOfweekCounter+dayMonth-1).set(dates.get(dayOfweekCounter+dayMonth-1).get() + "\n" + model.getShift(i).getUser_id());
        }
    }

    public StringProperty getProperyList(int i) {
        return dates.get(i);
    }

    public void clearCalendar() {
        for (int i = 0; i < 42; i++) {
            dates.get(i).set("");
        }
    }
}
