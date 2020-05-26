package view.createUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import view.ViewHandler;
import viewModel.createUser.CreateUserViewModel;

public class CreateUserController {

    private ViewHandler viewHandler;
    private CreateUserViewModel createUserViewModel;

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private ComboBox<String> statusComboBox;
    @FXML
    private ComboBox<String> accesslevelComboBox;

    @FXML
    private Label response;
    @FXML
    private Label labelFillFields;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelPassword;
    @FXML
    private Label labelFirstname;
    @FXML
    private Label labelLastname;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelStatus;
    @FXML
    private Label labelAccesslevel;
    @FXML
    private Label labelStatusString;
    @FXML
    private Label labelAccesslevelString;



    public void init(CreateUserViewModel vm, ViewHandler vh) {
        createUserViewModel = vm;
        viewHandler = vh;
        usernameTextField.textProperty().bindBidirectional(vm.usernameProperty());
        passwordTextField.textProperty().bindBidirectional(vm.passwordProperty());
        firstnameTextField.textProperty().bindBidirectional(vm.firstnameProperty());
        lastnameTextField.textProperty().bindBidirectional(vm.lastnameProperty());
        emailTextField.textProperty().bindBidirectional(vm.emailProperty());
        response.textProperty().bindBidirectional(vm.createEmployeeResponseProperty());
        labelStatusString.textProperty().bindBidirectional(vm.statusProperty());
        labelAccesslevelString.textProperty().bindBidirectional(vm.accesslevelProperty());

        statusComboBox.getItems().add("ACTIVE");
        statusComboBox.getItems().add("INACTIVE");

        accesslevelComboBox.getItems().add("EMPLOYEE");
        accesslevelComboBox.getItems().add("MANAGER");
    }

    public void onSubmitButton(ActionEvent event) {
        if(usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty() || firstnameTextField.getText().isEmpty()
                || lastnameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || statusComboBox.getSelectionModel().isEmpty()
                || accesslevelComboBox.getSelectionModel().isEmpty()) {
            setEmptyFieldsRed();
            labelFillFields.setText("Please fill the required fields...");
        } else {
            createUserViewModel.submitEmployee();
            System.out.println(response.getText());
            System.out.println(response + "view");


            if(response.getText().equals("Success")){
                viewHandler.openCalendarView();
                System.out.println("Changing to calendar");

            } else {
                response.setText("Connection to database couldn't be established...");
                System.out.println("Connection to database couldn't be established...");
            }
        }
    }

    public void onCancelButton(ActionEvent event) {
        createUserViewModel.clearFields();
        viewHandler.openCalendarViewOld();
    }

    public void onResetButton(ActionEvent event) {
        createUserViewModel.clearFields();
        statusComboBox.getSelectionModel().select(0);
        accesslevelComboBox.getSelectionModel().select(0);
        labelUsername.setTextFill(Color.BLACK);
        labelPassword.setTextFill(Color.BLACK);
        labelFirstname.setTextFill(Color.BLACK);
        labelLastname.setTextFill(Color.BLACK);
        labelEmail.setTextFill(Color.BLACK);

    }

    public void statusComboBox(ActionEvent event) {
        String selectedValue = statusComboBox.getValue();
        labelStatusString.setText(selectedValue);
    }

    public void accesslevelComboBox(ActionEvent event) {
        String selectedValue = accesslevelComboBox.getValue();
        labelAccesslevelString.setText(selectedValue);
    }

    private void setEmptyFieldsRed() {
        labelUsername.setTextFill(usernameTextField.getText().isEmpty() ? Color.RED : Color.BLACK);
        labelPassword.setTextFill(passwordTextField.getText().isEmpty() ? Color.RED : Color.BLACK);
        labelFirstname.setTextFill(firstnameTextField.getText().isEmpty() ? Color.RED : Color.BLACK);
        labelLastname.setTextFill(lastnameTextField.getText().isEmpty() ? Color.RED : Color.BLACK);
        labelEmail.setTextFill(emailTextField.getText().isEmpty() ? Color.RED : Color.BLACK);

        labelStatus.setTextFill(statusComboBox.getSelectionModel().isEmpty() ? Color.RED : Color.BLACK);
        labelAccesslevel.setTextFill(accesslevelComboBox.getSelectionModel().isEmpty() ? Color.RED : Color.BLACK);
    }
}