package clientNetworking.addUser;

import clientNetworking.resteasy.HTTPHandler;
import com.google.gson.Gson;
import shared.User;

public class AddUserClientImpl implements AddUserClient {
    private Gson jsonSerializer;
    private String response;
    private HTTPHandler httpHandler;

    public AddUserClientImpl(HTTPHandler httpHandler) {
        this.jsonSerializer = new Gson();
        this.httpHandler = httpHandler;
    }

    @Override
    public String addUser(User user) {
        // in future added path to Employees where Manager can add user
        String PATH = "http://127.0.0.1:5000/api/Calendar/Employees/AddUser";
        String newUserJson = jsonSerializer.toJson(user);
        System.out.println(newUserJson);
        response = httpHandler.postToAPI(newUserJson, PATH);
        return response;
    }

    @Override
    public String getResponse() {
        return response;
    }
}

