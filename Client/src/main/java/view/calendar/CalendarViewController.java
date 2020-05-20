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
        calendarViewModel = vm;
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
        //calendarViewModel.getUser();
        //String timeStamp = new SimpleDateFormat("MM-yyyy").format(Calendar.getInstance().getTime());
        //calendarViewModel.getCalendar(timeStamp);
        calendarViewModel.setCalendar();
    }
}
