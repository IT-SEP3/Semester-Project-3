package clientnetworking;

import clientnetworking.resteasy.HTTPHandler;
import shared.Shift;
import shared.User;
import com.google.gson.Gson;

public class ClientImp implements clientnetworking.Client {
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

    @Override // date format xx-xxxx
    public Shift[] getCalendarShifts(String username, String month) {
        String PATH ="http://127.0.0.1:5000/api/Shifts/?username=" +  username + "&date=" + month;
        String TestPATH ="http://127.0.0.1:5000/api/Login/?username=" +  username + "&date=" + month;
        response = httpHandler.GetFromAPI(TestPATH);
        return new Shift[0];
    }


    @Override
    public String getResponse() {
        return response;
    }
}
