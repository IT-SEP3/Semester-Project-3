package View.Login;


import View.ViewHandler;
import ViewModel.LoginVM.LoginVM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    private ViewHandler viewHandler;
    private LoginVM viewModel;

    public void init(LoginVM vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        userNameText.textProperty().bindBidirectional(vm.usernameProperty());
        passWordText.textProperty().bindBidirectional(vm.passwordProperty());
        response.textProperty().bindBidirectional(vm.loginResponseProperty());
    }
    //Insivisble field on the gui. That changes when the user does someting wrong or good
    @FXML
    private Label response;

    @FXML
    private TextField userNameText;

    @FXML
    private TextField passWordText;

    @FXML
    void onLogin(ActionEvent event) {
        viewModel.login();
    }
}
