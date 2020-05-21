package clientNetworking.addShift;

import clientNetworking.resteasy.HTTPHandler;
import com.google.gson.Gson;
import shared.Shift;


public class AddShiftClientImpl implements AddShiftClient {

    private Gson jsonSerializer;
    private String response;
    private HTTPHandler httpHandler;

    public AddShiftClientImpl(HTTPHandler httpHandler) {
        this.jsonSerializer = new Gson();
        this.httpHandler = httpHandler;
    }

    @Override
    public String AddShift(Shift shift) {
        String PATH = "http://127.0.0.1:5000/api/Calendar/AddShift/";
        String newShiftJson = jsonSerializer.toJson(shift);
        System.out.println(newShiftJson);
        response = httpHandler.PostToAPI(newShiftJson, PATH);
        return response;
    }

    @Override
    public String getResponse() {
        return response;
    }
}
