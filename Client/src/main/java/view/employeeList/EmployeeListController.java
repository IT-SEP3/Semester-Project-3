package view.employeeList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import shared.User;
import view.ViewHandler;
import viewModel.login.LoginViewModel;

public class EmployeeListController {

    @FXML
    private ListView<User> employeeList;
    private ViewHandler viewHandler;
    private LoginViewModel viewModel;

    public void init(LoginViewModel vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        employeeList = new ListView<>();
        vm.clearProperties();
    }


    @FXML
    void onBack(ActionEvent event) {
        viewHandler.openCalendarViewOld();
    }

    @FXML
    void onCreateEmployee(ActionEvent event) {
        viewHandler.openCreateUserView();
    }
}
