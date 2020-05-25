package view.calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import view.ViewHandler;
import viewModel.calendar.CalendarViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarViewController {
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
    private Label user;
    @FXML
    private Label access;
    @FXML
    private ComboBox<String> monthsBox;
    @FXML
    private ComboBox<String> yearBox;
    @FXML
    private Button createEmployee;
    @FXML
    private Button createShift;
    private ViewHandler viewHandler;
    private CalendarViewModel calendarViewModel;


    public void init(CalendarViewModel vm, ViewHandler vh) {
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
        date6x7.textProperty().bindBidirectional(calendarViewModel.getProperyList(41));
        //Menu side labels
        user.textProperty().bindBidirectional(calendarViewModel.getProperyList(42));
        access.textProperty().bindBidirectional(calendarViewModel.getProperyList(43));
        //Button accesibility for different access levels
        createEmployee.visibleProperty().bindBidirectional(calendarViewModel.getButtonsProperty());
        createShift.visibleProperty().bindBidirectional(calendarViewModel.getButtonsProperty());

        //Combobox year and month population
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
        yearBox.getItems().add("2019");
        yearBox.getItems().add("2020");
        yearBox.getItems().add("2021");
        yearBox.getItems().add("2022");
        yearBox.getItems().add("2023");
        yearBox.getItems().add("2024");
        yearBox.getItems().add("2025");
        yearBox.getItems().add("2026");

        Calendar calYear = Calendar.getInstance();
        yearBox.setValue(new SimpleDateFormat("yyyy").format(calYear.getTime()));
        Calendar cal = Calendar.getInstance();
        monthsBox.setValue(new SimpleDateFormat("MMMM").format(cal.getTime()));
        int monthNumber = 0;
        switch (monthsBox.getValue()) {
            case "January":
                monthNumber = 1;
                break;
            case "February":
                monthNumber = 2;
                break;
            case "March":
                monthNumber = 3;
                break;
            case "April":
                monthNumber = 4;
                break;
            case "May":
                monthNumber = 5;
                break;
            case "June":
                monthNumber = 6;
                break;
            case "July":
                monthNumber = 7;
                break;
            case "August":
                monthNumber = 8;
                break;
            case "September":
                monthNumber = 9;
                break;
            case "October":
                monthNumber = 10;
                break;
            case "November":
                monthNumber = 11;
                break;
            case "December":
                monthNumber = 12;
                break;

            default:
                monthNumber = 1;
                break;
        }
        createEmployee.visibleProperty().bindBidirectional(calendarViewModel.getButtonsProperty());
        calendarViewModel.getUser();
        calendarViewModel.setFunctionalityDifferences();
        //Years not flexible, what if its 2021 now
        calendarViewModel.getCalendar(monthNumber +"-"+ 2020);
        calendarViewModel.setCalendar(monthNumber, 2020);
    }

    @FXML
    void logOut(ActionEvent event) {
        viewHandler.openLoginView();
    }

    public void onCreateUser(ActionEvent event) {
        viewHandler.openCreateUserView();
    }

    public void onAddShift(ActionEvent event) {
        viewHandler.openAddShiftView();
    }

    @FXML
    void onSelectMonth(ActionEvent event) {
        int monthNumber = 0;
        switch (monthsBox.getValue()) {
            case "January":
                monthNumber = 1;
                break;
            case "February":
                monthNumber = 2;
                break;
            case "March":
                monthNumber = 3;
                break;
            case "April":
                monthNumber = 4;
                break;
            case "May":
                monthNumber = 5;
                break;
            case "June":
                monthNumber = 6;
                break;
            case "July":
                monthNumber = 7;
                break;
            case "August":
                monthNumber = 8;
                break;
            case "September":
                monthNumber = 9;
                break;
            case "October":
                monthNumber = 10;
                break;
            case "November":
                monthNumber = 11;
                break;
            case "December":
                monthNumber = 12;
                break;
        }
        calendarViewModel.getCalendar(monthNumber + "-" + yearBox.getValue());
        calendarViewModel.clearCalendar();
        calendarViewModel.setCalendar(monthNumber, Integer.parseInt(yearBox.getValue()));
    }


}
