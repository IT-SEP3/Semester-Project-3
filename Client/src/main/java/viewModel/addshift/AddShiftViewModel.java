package viewModel.addshift;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.addshift.IAddShiftModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class AddShiftViewModel {

    private IAddShiftModel model;
    private StringProperty description, response;

    public AddShiftViewModel(IAddShiftModel model) {
        this.model = model;
        description = new SimpleStringProperty();
        response = new SimpleStringProperty();
    }

    public ArrayList<String> getUsers() {
        return model.getUsers();
    }

    public void submitShift(LocalDate date, String employee) {

        if (description.get().isEmpty() || description.get().isEmpty()) {
            response.setValue("Please fill out the required fields to create a shift");
        }
        else {
            String API_response = model.addShift(description.getValue(), employee, date);
            response.setValue(API_response);
        }
    }

    public void clearFields() {
        description.setValue("");
        response.setValue("");
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public StringProperty responseProperty() {
        return response;
    }


}