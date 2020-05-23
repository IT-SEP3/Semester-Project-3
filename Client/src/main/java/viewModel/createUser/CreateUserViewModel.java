package viewModel.createUser;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;
import model.createUser.ICreateUserModel;

import javafx.scene.paint.Paint;

public class CreateUserViewModel {

    private StringProperty username, password, fname, lname, email, createEmployeeResponse, status, accesslevel;
    private Property<Paint> paintProperty;
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
        paintProperty = new SimpleObjectProperty<Paint>();
    }

    public Property<Paint> getPaintProperty(){
        return paintProperty;
    }

    public void submitEmployee() {
        if(username.get() != null && !username.get().isEmpty() && password.get() != null && !password.get().isEmpty()
                && fname.get() != null && !fname.get().isEmpty() && lname.get() != null && !lname.get().isEmpty()
                && email.get() != null && !email.get().isEmpty()) {
            model.createUser(username.getValue(), password.getValue(), fname.getValue(), lname.getValue(),
                    email.getValue(), status.getValue(), accesslevel.getValue());
            String response = model.createUserResponse();
            createEmployeeResponse.setValue(response);
        }
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

    public void setAllRed() {
        paintProperty.setValue(Color.RED);
    }
}
