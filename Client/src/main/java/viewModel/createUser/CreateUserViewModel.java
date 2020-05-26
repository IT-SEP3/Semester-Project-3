package viewModel.createUser;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.createUser.ICreateUserModel;


public class CreateUserViewModel {

    private StringProperty username, password, fname, lname, email, createEmployeeResponse, status, accesslevel;
    private ICreateUserModel model;

    public CreateUserViewModel(ICreateUserModel model) {
        this.model = model;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        fname = new SimpleStringProperty();
        lname = new SimpleStringProperty();
        email = new SimpleStringProperty();
        createEmployeeResponse = new SimpleStringProperty();
        status = new SimpleStringProperty();
        accesslevel = new SimpleStringProperty();
    }

    public void submitEmployee() {
            String API_reponse = model.createUser(username.getValue(), password.getValue(), fname.getValue(), lname.getValue(),
                email.getValue(), status.getValue(), accesslevel.getValue());
            createEmployeeResponse.setValue(API_reponse);
    }

    public void clearFields() {
        username.setValue("");
        password.setValue("");
        fname.setValue("");
        lname.setValue("");
        email.setValue("");
    }


    public StringProperty usernameProperty() {
        return username;
    }


    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty firstnameProperty() {
        return fname;
    }

    public StringProperty lastnameProperty() {
        return lname;
    }

    public StringProperty emailProperty(){
        return email;
    }

    public StringProperty createEmployeeResponseProperty() {
        return createEmployeeResponse;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public StringProperty accesslevelProperty() {
        return accesslevel;
    }
}
