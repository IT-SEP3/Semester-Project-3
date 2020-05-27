package viewModel.employeeList;

import model.createUser.ICreateUserModel;
import model.employeeList.IEmployeeListModel;
import shared.User;

import java.util.ArrayList;

public class EmployeeListViewModel {

    private IEmployeeListModel model;

    public EmployeeListViewModel(IEmployeeListModel employeeListModel) {
        model = employeeListModel;
    }

    public ArrayList<User> populateListView() {
        return model.getEmployees();
    }
}
