package view;


import view.calendar.CalendarViewController;
import view.login.LoginViewController;
import viewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewHandler {
    private ViewModelFactory viewModelFactory;
    private Stage mainStage;
    private Scene loginScene;
    private Scene calendarScene;
    private Scene createUser;

    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        viewModelFactory = vmf;
        mainStage = stage;
    }

    public void start() {
        openLoginView();
        mainStage.show();
    }

    public void openLoginView() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = getRootByPath("Login/Login.fxml", loader);
        LoginViewController controller = loader.getController();
        controller.init(viewModelFactory.getLoginViewModel(), this);
        loginScene = new Scene(root);
        mainStage.setTitle("Login");
        mainStage.setScene(loginScene);
    }

    public void openCalendarView() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = getRootByPath("calendar/Calendar.fxml", loader);
        CalendarViewController controller = loader.getController();
        controller.init(viewModelFactory.getCalendarViewModel(), this);
        calendarScene = new Scene(root);
        mainStage.setTitle("Calendar");
        mainStage.setScene(calendarScene);
    }

    public void openCreateEmployeeView() {
        FXMLLoader loader = new FXMLLoader();
        if (createUser == null) {
            Parent root = getRootByPath("createUser/CreateUser.fxml", loader);
            CalendarViewController controller = loader.getController();
            controller.init(viewModelFactory.getCalendarViewModel(), this);
            createUser = new Scene(root);
        }
        mainStage.setTitle("Create User");
        mainStage.setScene(createUser);
    }

    private Parent getRootByPath(String path, FXMLLoader loader) {
        loader.setLocation(getClass().getResource(path));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return root;
    }


}
