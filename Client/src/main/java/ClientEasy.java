import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.Scanner;

public class ClientEasy {
    private static String path = "http://localhost:5000/api/Employees";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Type employee name: ");

            Employee tmp = new Employee(input.nextLine());

            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target(path);

            Response response = target.request().post(Entity.entity(tmp, "application/json"));

            System.out.println(response.getStatus());
        }
    }
}
