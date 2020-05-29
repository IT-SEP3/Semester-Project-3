package view.employeeList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Shift;
import shared.User;
import view.ViewHandler;
import viewModel.employeeList.EmployeeListViewModel;

import java.util.Optional;

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

    @FXML
    void onDeleteUser(ActionEvent event) {
        boolean delete = false;
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Do you want to delete this user?");
        alert.setTitle("Delete user");
        alert.setHeaderText("Do you want to delete this user?");

        ButtonType cancelButtonType =  new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getDialogPane().getButtonTypes().add(cancelButtonType);

        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            delete = true;
        }
        if(delete){
            User seleced = tableOfEmployees.getSelectionModel().getSelectedItem();
            viewModel.saveUser(seleced);
            viewModel.deleteUser(seleced.getId());
        }
        viewHandler.openEmployeeListView();
    }
}
