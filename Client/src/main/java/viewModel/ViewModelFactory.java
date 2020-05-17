package viewModel;


import model.ModelFactory;
import viewModel.login.LoginViewModel;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private LoginViewModel loginViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLoginViewModel() {
        if(loginViewModel == null)
            loginViewModel = new LoginViewModel(modelFactory.userModel());
        return loginViewModel;
    }
}
