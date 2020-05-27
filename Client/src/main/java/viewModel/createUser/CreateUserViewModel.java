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
    private Property<Paint> usernamePaint, passwordPaint, fnamePaint, lnamePaint, emailPaint;
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

        usernamePaint = new SimpleObjectProperty<Paint>();
        passwordPaint = new SimpleObjectProperty<Paint>();
        fnamePaint = new SimpleObjectProperty<Paint>();
        lnamePaint = new SimpleObjectProperty<Paint>();
        emailPaint = new SimpleObjectProperty<Paint>();
    }

    public void submitEmployee() {
        resetColors();
        if(username.get() != null && !username.get().isEmpty()){
            if(password.get() != null && !password.get().isEmpty()){
                if(fname.get() != null && !fname.get().isEmpty()){
                    if(lname.get() != null && !lname.get().isEmpty()){
                       if(email.get() != null && !email.get().isEmpty()){
                           String API_reponse = model.createUser(username.getValue(), password.getValue(), fname.getValue(), lname.getValue(),
                                   email.getValue(), status.getValue(), accesslevel.getValue());
                           createEmployeeResponse.setValue(API_reponse);
                       }else {
                           createEmployeeResponse.set("Enter email");
                           emailPaint.setValue(Color.RED);
                       }
                    }else {
                        createEmployeeResponse.set("Enter last name");
                        lnamePaint.setValue(Color.RED);
                    }
                }else {
                    createEmployeeResponse.set("Enter first name");
                    fnamePaint.setValue(Color.RED);
                }
            }else {
                createEmployeeResponse.set("Enter password");
                passwordPaint.setValue(Color.RED);
            }
        }else {
            createEmployeeResponse.set("Enter username");
            usernamePaint.setValue(Color.RED);
        }
    }

    public void clearFields() {
        username.setValue("");
        password.setValue("");
        fname.setValue("");
        lname.setValue("");
        email.setValue("");
        resetColors();
    }

    public void resetColors(){
        usernamePaint.setValue(Color.BLACK);
        passwordPaint.setValue(Color.BLACK);
        fnamePaint.setValue(Color.BLACK);
        lnamePaint.setValue(Color.BLACK);
        emailPaint.setValue(Color.BLACK);
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

    public Property<Paint> usernamePaintProperty() {
        return usernamePaint;
    }

    public Property<Paint> passwordPaintProperty() {
        return passwordPaint;
    }

    public Property<Paint> fnamePaintProperty() {
        return fnamePaint;
    }

    public Property<Paint> lnamePaintProperty() {
        return lnamePaint;
    }

    public Property<Paint> emailPaintProperty() {
        return emailPaint;
    }
}
