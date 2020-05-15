
import ClientNetworking.Client;
import ClientNetworking.ClientImp;
import ClientNetworking.restEASY.HTTPHandler;
import Model.ModelFactory;
import Shared.User;
import View.ViewHandler;
import ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

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
