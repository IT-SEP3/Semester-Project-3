import clientNetworking.Client;
import clientNetworking.ClientImp;
import clientNetworking.restEASY.HTTPHandler;
import javafx.application.Application;
import javafx.stage.Stage;
import model.ModelFactory;
import view.ViewHandler;
import viewModel.ViewModelFactory;

public class EmployeePlannerApp extends Application {

    @Override
    public void start(Stage stage) {
        HTTPHandler httpHandler = new HTTPHandler();
        Client client = new ClientImp(httpHandler);
        ModelFactory modelFactory = new ModelFactory(client);
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();
    }
}
