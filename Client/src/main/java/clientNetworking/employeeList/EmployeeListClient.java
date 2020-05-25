package clientNetworking.employeeList;

import clientNetworking.HTTPHandler;
import clientNetworking.createUser.ICreateUserClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import shared.Shift;
import shared.User;

import javax.xml.ws.spi.http.HttpHandler;
import java.lang.reflect.Type;
import java.net.HttpCookie;
import java.util.ArrayList;

public class EmployeeListClient implements IEmployeeListClient {
    private Gson jsonSerializer;
    private String response;
    private HTTPHandler httpHandler;

    public EmployeeListClient(HTTPHandler httpHandler) {
        this.httpHandler = httpHandler;
    }

    @Override
    public ArrayList<User> getEmployees(int managerId) {
        Type listType = new TypeToken<ArrayList<User>>(){}.getType();
        String PATH ="http://127.0.0.1:5000/api/User/?managerId="+ managerId ;
        response = httpHandler.getFromAPI(PATH);
        ArrayList<User> shifts = jsonSerializer.fromJson(response, listType);
        return shifts;
    }
}
