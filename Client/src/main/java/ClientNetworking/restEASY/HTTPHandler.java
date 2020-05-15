package ClientNetworking.restEASY;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class HTTPHandler {

    public HTTPHandler() {
    }

    public String SendToAPI(String json, String URL) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URL);

        Response response = target.request().post(Entity.entity(json, "application/json"));
        System.out.println(response);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        System.out.println(response.readEntity(String.class));

        return response.readEntity(String.class);
    }
}
