package ViewModel;


import Model.ModelFactory;
import ViewModel.LoginVM.LoginVM;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private LoginVM loginVM;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginVM getLoginVM() {
        if(loginVM == null)
            loginVM = new LoginVM(modelFactory.userModel());
        return loginVM;
    }
}
