package viewModel;


import model.ModelFactory;
import viewModel.calendar.CalendarViewModel;
import viewModel.login.LoginViewModel;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private LoginViewModel loginViewModel;
    private CalendarViewModel calendarViewModel;

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
}
