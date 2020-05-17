package clientNetworking;


import clientNetworking.restEASY.HTTPHandler;
import com.google.gson.Gson;
import shared.Shift;
import shared.User;

public class ClientImp implements Client {
    private Gson jsonSerializer;
    private String response;
    private HTTPHandler httpHandler;


    public ClientImp(HTTPHandler httpHandler){
        this.httpHandler = httpHandler;
        this.jsonSerializer = new Gson();
    }

    @Override
    public String Login(User loginCarrier) {
        String PATH ="http://127.0.0.1:5000/api/Login";
        String loginJson = jsonSerializer.toJson(loginCarrier);
        System.out.println(loginJson);
        response = httpHandler.PostToAPI(loginJson, PATH);
        return response;
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
