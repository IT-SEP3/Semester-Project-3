package view.employeeList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import shared.User;
import view.ViewHandler;
import viewModel.employeeList.EmployeeListViewModel;

public class EmployeeListController {
    @FXML
    private TableView<User> tableOfEmployees;

    @FXML
    private TableColumn<User, Integer> tableID;

    @FXML
    private TableColumn<User, String> tableUsername;

    @FXML
    private TableColumn<User, String> tableFname;

    @FXML
    private TableColumn<User, String> tableLname;

    @FXML
    private TableColumn<User, String> tableEmail;

    @FXML
    private TableColumn<User, String> tableAcessLevel;

    @FXML
    private TableColumn<User, String> tableStatus;

    @FXML
    private ListView<String> employeeList;
    private ViewHandler viewHandler;
    private EmployeeListViewModel viewModel;
    private ObservableList<User> users = FXCollections.observableArrayList();

    public void init(EmployeeListViewModel vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        //employeeList.getItems().addAll(viewModel.populateListView());
        users.addAll(viewModel.populateListView());
        tableOfEmployees.setItems(users);
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
