package view.calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import view.ViewHandler;
import viewModel.calendar.CalendarViewModel;
import viewModel.login.LoginViewModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarViewController {

    private ViewHandler viewHandler;
    private CalendarViewModel calendarViewModel;

    @FXML
    private Label date1x1 = new Label();
    @FXML
    private Label date1x2 = new Label();
    @FXML
    private Label date1x3 = new Label();
    @FXML
    private Label date1x4 = new Label();
    @FXML
    private Label date1x5 = new Label();
    @FXML
    private Label date1x6 = new Label();
    @FXML
    private Label date1x7 = new Label();
    @FXML
    private Label date2x1 = new Label();
    @FXML
    private Label date2x2 = new Label();
    @FXML
    private Label date2x3 = new Label();
    @FXML
    private Label date2x4 = new Label();
    @FXML
    private Label date2x5 = new Label();
    @FXML
    private Label date2x6 = new Label();
    @FXML
    private Label date2x7 = new Label();
    @FXML
    private Label date3x1 = new Label();
    @FXML
    private Label date3x2 = new Label();
    @FXML
    private Label date3x3 = new Label();
    @FXML
    private Label date3x4 = new Label();
    @FXML
    private Label date3x5 = new Label();
    @FXML
    private Label date3x6 = new Label();
    @FXML
    private Label date3x7 = new Label();
    @FXML
    private Label date4x1 = new Label();
    @FXML
    private Label date4x2 = new Label();
    @FXML
    private Label date4x3 = new Label();
    @FXML
    private Label date4x4 = new Label();
    @FXML
    private Label date4x5 = new Label();
    @FXML
    private Label date4x6 = new Label();
    @FXML
    private Label date4x7 = new Label();
    @FXML
    private Label date5x1 = new Label();
    @FXML
    private Label date5x2 = new Label();
    @FXML
    private Label date5x3 = new Label();
    @FXML
    private Label date5x4 = new Label();
    @FXML
    private Label date5x5 = new Label();
    @FXML
    private Label date5x6 = new Label();
    @FXML
    private Label date5x7 = new Label();
    @FXML
    private Label date6x1 = new Label();
    @FXML
    private Label date6x2 = new Label();
    @FXML
    private Label date6x3 = new Label();
    @FXML
    private Label date6x4 = new Label();
    @FXML
    private Label date6x5 = new Label();
    @FXML
    private Label date6x6 = new Label();
    @FXML
    private Label date6x7 = new Label();

    @FXML
    private ComboBox<String> monthsBox;



    public void init(CalendarViewModel vm, ViewHandler vh){
        calendarViewModel = vm;
        viewHandler = vh;
        date1x1.textProperty().bindBidirectional(calendarViewModel.getProperyList(0));
        date1x2.textProperty().bindBidirectional(calendarViewModel.getProperyList(1));
        date1x3.textProperty().bindBidirectional(calendarViewModel.getProperyList(2));
        date1x4.textProperty().bindBidirectional(calendarViewModel.getProperyList(3));
        date1x5.textProperty().bindBidirectional(calendarViewModel.getProperyList(4));
        date1x6.textProperty().bindBidirectional(calendarViewModel.getProperyList(5));
        date1x7.textProperty().bindBidirectional(calendarViewModel.getProperyList(6));
        date2x1.textProperty().bindBidirectional(calendarViewModel.getProperyList(7));
        date2x2.textProperty().bindBidirectional(calendarViewModel.getProperyList(8));
        date2x3.textProperty().bindBidirectional(calendarViewModel.getProperyList(9));
        date2x4.textProperty().bindBidirectional(calendarViewModel.getProperyList(10));
        date2x5.textProperty().bindBidirectional(calendarViewModel.getProperyList(11));
        date2x6.textProperty().bindBidirectional(calendarViewModel.getProperyList(12));
        date2x7.textProperty().bindBidirectional(calendarViewModel.getProperyList(13));
        date3x1.textProperty().bindBidirectional(calendarViewModel.getProperyList(14));
        date3x2.textProperty().bindBidirectional(calendarViewModel.getProperyList(15));
        date3x3.textProperty().bindBidirectional(calendarViewModel.getProperyList(16));
        date3x4.textProperty().bindBidirectional(calendarViewModel.getProperyList(17));
        date3x5.textProperty().bindBidirectional(calendarViewModel.getProperyList(18));
        date3x6.textProperty().bindBidirectional(calendarViewModel.getProperyList(19));
        date3x7.textProperty().bindBidirectional(calendarViewModel.getProperyList(20));
        date4x1.textProperty().bindBidirectional(calendarViewModel.getProperyList(21));
        date4x2.textProperty().bindBidirectional(calendarViewModel.getProperyList(22));
        date4x3.textProperty().bindBidirectional(calendarViewModel.getProperyList(23));
        date4x4.textProperty().bindBidirectional(calendarViewModel.getProperyList(24));
        date4x5.textProperty().bindBidirectional(calendarViewModel.getProperyList(25));
        date4x6.textProperty().bindBidirectional(calendarViewModel.getProperyList(26));
        date4x7.textProperty().bindBidirectional(calendarViewModel.getProperyList(27));
        date5x1.textProperty().bindBidirectional(calendarViewModel.getProperyList(28));
        date5x2.textProperty().bindBidirectional(calendarViewModel.getProperyList(29));
        date5x3.textProperty().bindBidirectional(calendarViewModel.getProperyList(30));
        date5x4.textProperty().bindBidirectional(calendarViewModel.getProperyList(31));
        date5x5.textProperty().bindBidirectional(calendarViewModel.getProperyList(32));
        date5x6.textProperty().bindBidirectional(calendarViewModel.getProperyList(33));
        date5x7.textProperty().bindBidirectional(calendarViewModel.getProperyList(34));
        date6x1.textProperty().bindBidirectional(calendarViewModel.getProperyList(35));
        date6x2.textProperty().bindBidirectional(calendarViewModel.getProperyList(36));
        date6x3.textProperty().bindBidirectional(calendarViewModel.getProperyList(37));
        date6x4.textProperty().bindBidirectional(calendarViewModel.getProperyList(38));
        date6x5.textProperty().bindBidirectional(calendarViewModel.getProperyList(39));
        date6x6.textProperty().bindBidirectional(calendarViewModel.getProperyList(40));
        date6x7.textProperty().bindBidirectional(calendarViewModel.getProperyList(41));;

        Calendar cal = Calendar.getInstance();
        monthsBox.setValue(new SimpleDateFormat("MMMM").format(cal.getTime()));

        monthsBox.getItems().add("January");
        monthsBox.getItems().add("February");
        monthsBox.getItems().add("March");
        monthsBox.getItems().add("April");
        monthsBox.getItems().add("May");
        monthsBox.getItems().add("June");
        monthsBox.getItems().add("July");
        monthsBox.getItems().add("August");
        monthsBox.getItems().add("September");
        monthsBox.getItems().add("October");
        monthsBox.getItems().add("November");
        monthsBox.getItems().add("December");



        //Calendar calYear = Calendar.getInstance();
        //chooseYear.setValue(new SimpleDateFormat("yyyy").format(calYear.getTime()));
        //chooseYear.getItems().setAll("2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026");


        calendarViewModel.getUser();
        String timeStamp = new SimpleDateFormat("MM-yyyy").format(Calendar.getInstance().getTime());
        calendarViewModel.getCalendar(timeStamp);
        try{
            Date date = new SimpleDateFormat("MMM").parse(monthsBox.getValue());
            Calendar cal2 = Calendar.getInstance();
            cal.setTime(date);
            int monthNumber=cal.get(Calendar.MONTH);
            calendarViewModel.setCalendar(monthNumber,2020);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onSelectMonth(ActionEvent event) {
        System.out.println("Trying to change month");
        try{
            Date date = new SimpleDateFormat("MMM").parse(monthsBox.getValue());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int monthNumber=cal.get(Calendar.MONTH);
            calendarViewModel.getCalendar(monthNumber + "-" + 2020);//monthsBox.getValue());
            calendarViewModel.clearCalendar();
            calendarViewModel.setCalendar(monthNumber, 2020);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


/*
    @FXML
    void onSelect(ActionEvent event) {
        try{
            Date date = new SimpleDateFormat("MMM").parse(chooseMonth.getValue());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int monthNumber=cal.get(Calendar.MONTH);
            calendarViewModel.getCalendar(monthNumber + "-" + chooseMonth.getValue());
            calendarViewModel.setCalendar();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    */
}
