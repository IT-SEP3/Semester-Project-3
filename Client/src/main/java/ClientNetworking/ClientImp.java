package ClientNetworking;

import ClientNetworking.restEASY.HTTPHandler;
import Shared.Shift;
import Shared.User;
import com.google.gson.Gson;

public class ClientImp implements ClientNetworking.Client {
    private Gson jsonSerializer;
    private String response;
    private HTTPHandler httpHandler;


    public ClientImp(HTTPHandler httpHandler){
        this.httpHandler = httpHandler;
        this.jsonSerializer = new Gson();
    }

    @Override
    public void Login(User loginCarrier) {
        String PATH ="http://127.0.0.1:5000/api/Login";
        String loginJson = jsonSerializer.toJson(loginCarrier);
        response = httpHandler.PostToAPI(loginJson, PATH);
        System.out.println(loginJson);
    }

    @Override
    public Shift[] getCalendarShifts(String username, String month) {
        String PATH ="http://127.0.0.1:5000/api/Calendar/" +  username + "/" + month;
        response = httpHandler.PostToAPI(loginJson, PATH);
        return new Shift[0];
    }


    @Override
    public String getResponse() {
        return response;
    }
}
