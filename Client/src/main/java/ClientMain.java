import ClientNetworking.Client;
import ClientNetworking.ClientImp;
import ClientNetworking.ClientSocketHandler;
import Model.ModelFactory;
import View.ViewHandler;
import ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClientMain extends Application {

    private static String path ="http://127.0.0.1:5000/api/Login";

    @Override
    public void start(Stage stage) throws Exception {
        Client client = new ClientImp();
        ModelFactory mf = new ModelFactory(client);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(stage, vmf);
        vh.start();

        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(path);

        Response response = target.request().post(Entity.entity(tmp, "application/json"));

        System.out.println(response.getStatus());

    }
}
