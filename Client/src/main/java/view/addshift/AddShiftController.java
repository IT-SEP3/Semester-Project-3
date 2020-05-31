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
        try {
            if (shiftDatePicker.getValue() == null ) {
                response.setText("Please fill out a date");
                if (descriptionTextField.getText() == null) {
                    response.setText("Please fill out a description");
                }
            } else {
                addShiftViewModel.submitShift(shiftDatePicker.getValue(), employeeComboBox.getValue(), descriptionTextField.getText());
            }
        }catch (NullPointerException e){
            response.setText("Please choose an employee");
        }
    }

    public void onCancelButton(ActionEvent event) {
        addShiftViewModel.clearFields();
        employeeComboBox.getSelectionModel().select(1);
        shiftDatePicker.setValue(null);
        viewHandler.openCalendarView();
    }

    public void onResetButton(ActionEvent event) {
        addShiftViewModel.clearFields();
        employeeComboBox.getSelectionModel().select(1);
        shiftDatePicker.setValue(null);
    }

}
