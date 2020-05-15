package ClientNetworking.restEASY;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class HTTPHandler {

    public HTTPHandler() {
    }

    public Response SendToAPI(String json, String URL) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URL);

        Response result = target.request().post(Entity.entity(json, "application/json"));
        System.out.println(result);

        return result;
    }
}
