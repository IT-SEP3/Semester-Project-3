package view.addshift;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.ViewHandler;
import viewModel.addshift.AddShiftViewModel;

public class AddShiftController {

    private ViewHandler viewHandler;
    private AddShiftViewModel addShiftViewModel;

    @FXML
    private DatePicker shiftDatePicker;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private ComboBox<String> employeeComboBox;
    @FXML
    private Label response;

    public void init(AddShiftViewModel vm, ViewHandler vh) {
        addShiftViewModel = vm;
        viewHandler = vh;
        descriptionTextField.textProperty().bindBidirectional(vm.descriptionProperty());
        response.textProperty().bindBidirectional(vm.responseProperty());
        employeeComboBox.getItems().addAll(vm.getUsers());
    }

    public void onSubmitButton(ActionEvent event) {

        if (employeeComboBox.getValue().contains("Choose an employee") || shiftDatePicker.getValue() == null ) {
            response.setText("Please fill out the required fields to create a shift");
        } else {
            addShiftViewModel.submitShift(shiftDatePicker.getValue(), employeeComboBox.getValue());
        }
    }

    public void onCancelButton(ActionEvent event) {
        addShiftViewModel.clearFields();
        employeeComboBox.getSelectionModel().select(0);
        shiftDatePicker.getEditor().clear();
        viewHandler.openCalendarView();
    }

    public void onResetButton(ActionEvent event) {
        addShiftViewModel.clearFields();
        employeeComboBox.getSelectionModel().select(0);
        shiftDatePicker.getEditor().clear();
    }

}
