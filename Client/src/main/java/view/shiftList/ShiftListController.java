package view.shiftList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Shift;
import shared.User;
import view.ViewHandler;

import viewModel.shiftList.ShiftListViewModel;

import java.time.LocalDate;
import java.util.Optional;

public class ShiftListController {
    @FXML
    private TableView<Shift> table;

    @FXML
    private TableColumn<Shift, Integer> shiftID;

    @FXML
    private TableColumn<Shift, Integer> managerID;

    @FXML
    private TableColumn<Shift, Integer> workerID;

    @FXML
    private TableColumn<Shift, LocalDate> dateID;

    @FXML
    private TableColumn<Shift, String> descriptionID;



    private ViewHandler viewHandler;
    private ShiftListViewModel viewModel;
    private ObservableList<Shift> shifts = FXCollections.observableArrayList();

    public void init(ShiftListViewModel vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        shiftID.setCellValueFactory(new PropertyValueFactory<Shift, Integer>("id"));
        managerID.setCellValueFactory(new PropertyValueFactory<Shift, Integer>("username"));
        workerID.setCellValueFactory(new PropertyValueFactory<Shift, Integer>("fname"));
        dateID.setCellValueFactory(new PropertyValueFactory<Shift, LocalDate>("lname"));
        descriptionID.setCellValueFactory(new PropertyValueFactory<Shift, String>("Email"));

        shifts.addAll(viewModel.populateListView());
        table.setItems(shifts);
    }

    @FXML
    void onBack(ActionEvent event) {
        viewHandler.openCalendarView();
    }

    @FXML
    void onDeleteShift(ActionEvent event) {
        Shift shift = table.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete shift");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this shift?" + shift.getId());
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK){
            viewModel.removeShift(shift.getId());
        }
    }
}
