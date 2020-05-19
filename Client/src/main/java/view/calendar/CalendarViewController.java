package view.calendar;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import view.ViewHandler;
import viewModel.calendar.CalendarViewModel;
import viewModel.login.LoginViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarViewController {

    private ViewHandler viewHandler;
    private CalendarViewModel calendarViewModel;

    @FXML
    private ChoiceBox selectMonth = new ChoiceBox();

    // date label first number is row second is column
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


    public void init(CalendarViewModel vm, ViewHandler vh){
        viewHandler = vh;
        calendarViewModel = vm;

        selectMonth.getItems().add("January");
        selectMonth.getItems().add("February");
        selectMonth.getItems().add("March");
        selectMonth.getItems().add("April");
        selectMonth.getItems().add("May");
        selectMonth.getItems().add("June");
        selectMonth.getItems().add("July");
        selectMonth.getItems().add("August");
        selectMonth.getItems().add("September");
        selectMonth.getItems().add("October");
        selectMonth.getItems().add("November");
        selectMonth.getItems().add("December");

        String timeStamp = new SimpleDateFormat("MM-yyyy").format(Calendar.getInstance().getTime());
        calendarViewModel.getCalendar(timeStamp);
    }
}
