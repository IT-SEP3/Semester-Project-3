import ClientNetworking.Client;
import ClientNetworking.ClientImp;
import ClientNetworking.ClientSocketHandler;
import Model.ModelFactory;
import View.ViewHandler;
import ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClientMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Client client = new ClientImp();
        ModelFactory mf = new ModelFactory(client);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(stage, vmf);
        vh.start();
    }
}
