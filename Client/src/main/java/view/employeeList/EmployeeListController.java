package view.employeeList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import shared.User;
import view.ViewHandler;
import viewModel.employeeList.EmployeeListViewModel;
import viewModel.login.LoginViewModel;

public class EmployeeListController {

    @FXML
    private ListView<String> employeeList;
    private ViewHandler viewHandler;
    private EmployeeListViewModel viewModel;

    public void init(EmployeeListViewModel vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        employeeList = new ListView<>();
        //employeeList.getItems().addAll(vm.populateListView());
    }


    @FXML
    void onBack(ActionEvent event) {
        viewHandler.openCalendarView();
    }

    @FXML
    void onCreateEmployee(ActionEvent event) {
        viewHandler.openCreateUserView();
    }
}
