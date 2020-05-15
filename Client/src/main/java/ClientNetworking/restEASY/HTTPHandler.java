package ClientNetworking.restEASY;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class HTTPHandler {
    private ResteasyClient client;
    private ResteasyWebTarget target;

    public HTTPHandler() {
    }

    public String PostToAPI(String json, String URL) {
        Response response;
        try{
            client = new ResteasyClientBuilder().build();
            target = client.target(URL);

            response = target.request().post(Entity.entity(json, "application/json"));
            System.out.println(response);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            System.out.println(response.readEntity(String.class));
        } catch (ProcessingException e){
            e.fillInStackTrace();
            return "Server not responding";
        }
        return response.readEntity(String.class);
    }

    public String GetFromApi(String URL){
        Response response;
        try{
            client = new ResteasyClientBuilder().build();
            target = client.target(URL);

            response = target.request().get(Response.class);
            System.out.println(response);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            System.out.println(response.readEntity(String.class));
        } catch (ProcessingException e){
            e.fillInStackTrace();
            return "Server not responding";
        }
        return response.readEntity(String.class);
    }
}
