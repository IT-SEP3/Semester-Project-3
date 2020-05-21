package clientNetworking.login;


import clientNetworking.resteasy.HTTPHandler;
import com.google.gson.Gson;
import shared.Shift;
import shared.User;

public class LoginClientImpl implements LoginClient {
    private Gson jsonSerializer;
    private String response;
    private HTTPHandler httpHandler;


    public LoginClientImpl(HTTPHandler httpHandler) {
        this.httpHandler = httpHandler;
        this.jsonSerializer = new Gson();
    }

    @Override
    public String Login(User loginCarrier) {
        String PATH = "http://127.0.0.1:5000/api/Login";
        String loginJson = jsonSerializer.toJson(loginCarrier);
        System.out.println(loginJson);
        response = httpHandler.PostToAPI(loginJson, PATH);
        return response;
    }

    @Override
    public String getResponse() {
        return response;
    }
}
