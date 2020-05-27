package view.employeeList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    private ViewHandler viewHandler;
    private EmployeeListViewModel viewModel;
    private ObservableList<User> users = FXCollections.observableArrayList();

    public void init(EmployeeListViewModel vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        tableID.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        tableUsername.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        tableFname.setCellValueFactory(new PropertyValueFactory<User, String>("fname"));
        tableLname.setCellValueFactory(new PropertyValueFactory<User, String>("lname"));
        tableEmail.setCellValueFactory(new PropertyValueFactory<User, String>("Email"));
        tableAcessLevel.setCellValueFactory(new PropertyValueFactory<User, String>("accessLevel"));
        tableStatus.setCellValueFactory(new PropertyValueFactory<User, String>("Status"));

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
