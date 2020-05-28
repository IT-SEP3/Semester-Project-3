package view.shiftList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
        managerID.setCellValueFactory(new PropertyValueFactory<Shift, Integer>("user_id"));
        workerID.setCellValueFactory(new PropertyValueFactory<Shift, Integer>("manager_id"));
        dateID.setCellValueFactory(new PropertyValueFactory<Shift, LocalDate>("date"));
        descriptionID.setCellValueFactory(new PropertyValueFactory<Shift, String>("description"));

        shifts.addAll(viewModel.populateListView());
        table.setItems(shifts);
    }

    @FXML
    void onBack(ActionEvent event) {
        viewHandler.openCalendarView();
    }

    @FXML
    void onDeleteShift(ActionEvent event) {

        boolean delete = false;
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Do you want to delete this shift?");
        alert.setTitle("Delete shift");
        alert.setHeaderText("");

        ButtonType cancelButtonType =  new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getDialogPane().getButtonTypes().add(cancelButtonType);

        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            delete = true;
        }
        if(delete){
            Shift shift = table.getSelectionModel().getSelectedItem();
            viewModel.removeShift(shift.getId());
            System.out.println(shift.getId());
        }
    }

    @FXML
    void onEdit(ActionEvent event) {
        Shift selected = table.getSelectionModel().getSelectedItem();
        viewModel.saveShiftForEditing(selected);
        //viewHandler.openEditShift();

    }
}
