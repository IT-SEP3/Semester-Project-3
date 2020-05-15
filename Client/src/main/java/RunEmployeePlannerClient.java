import Shared.User;
import javafx.application.Application;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class RunEmployeePlannerClient {

    public static void main(String[] args) {

        Application.launch(EmployeePlannerApp.class);

    }
}
