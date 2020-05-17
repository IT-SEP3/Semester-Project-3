
import clientnetworking.Client;
import clientnetworking.ClientImp;
import clientnetworking.resteasy.HTTPHandler;
import model.ModelFactory;
import view.ViewHandler;
import viewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class EmployeePlannerApp extends Application {

    @Override
    public void start(Stage stage) {

        HTTPHandler httpHandler = new HTTPHandler();
        Client client = new ClientImp(httpHandler);
        client.getCalendarShifts("kjjj", "05-2020");
        ModelFactory modelFactory = new ModelFactory(client);
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();
    }
}
