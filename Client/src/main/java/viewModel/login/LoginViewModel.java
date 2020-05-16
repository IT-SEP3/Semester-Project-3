package viewModel.login;


import model.login.LoginModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class LoginViewModel {

    private StringProperty username, password, loginResponse;
    private LoginModel model;

    public LoginViewModel(LoginModel loginModel) {
        this.model = loginModel;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        loginResponse = new SimpleStringProperty();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty loginResponseProperty() {
        return loginResponse;
    }
    //Checks if login fields are empty. If not hashes password and sends it to model. And also gets response from server. And also violates solid principles
    public void login() {
        if(username.get() != null && !username.get().isEmpty() && password.get() != null && !username.get().isEmpty()) {
            loginResponse.setValue(null);
            model.login(username.get(), password.get());

            String response = model.loginResponse();
            loginResponse.set(response);
        }
        else{
            loginResponse.setValue("Must enter both, username and password");
            username.setValue(null);
            password.setValue(null);
        }
    }
}
