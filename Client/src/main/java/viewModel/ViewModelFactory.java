package viewModel;


import model.ModelFactory;
import viewModel.addshift.AddShiftViewModel;
import viewModel.calendar.CalendarViewModel;
import viewModel.createUser.CreateUserViewModel;
import viewModel.employeeList.EmployeeListViewModel;
import viewModel.login.LoginViewModel;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private LoginViewModel loginViewModel;
    private CalendarViewModel calendarViewModel;
    private CreateUserViewModel userViewModel;
    private AddShiftViewModel addShiftViewModel;
    private EmployeeListViewModel employeeListViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLoginViewModel() {
        if(loginViewModel == null)
            loginViewModel = new LoginViewModel(modelFactory.loginModel());
        return loginViewModel;
    }

    public CalendarViewModel getCalendarViewModel() {
        if(calendarViewModel == null)
            calendarViewModel = new CalendarViewModel(modelFactory.calendarModel());
        return calendarViewModel;
    }

    public CreateUserViewModel getUserViewModel() {
        if (userViewModel == null)
            userViewModel = new CreateUserViewModel(modelFactory.createUserModel());
        return userViewModel;
    }

    public AddShiftViewModel getAddShiftViewModel() {
        if (addShiftViewModel == null)
            addShiftViewModel = new AddShiftViewModel(modelFactory.addShiftModel());
        return addShiftViewModel;
    }

    public EmployeeListViewModel getEmployeeListViewModel() {
        if (employeeListViewModel == null)
            employeeListViewModel = new EmployeeListViewModel(modelFactory.employeeListModel());
        return employeeListViewModel;
    }
}
