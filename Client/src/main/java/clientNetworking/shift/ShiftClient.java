package clientNetworking.shift;

import clientNetworking.HTTPHandler;
import com.google.gson.Gson;
import shared.Shift;

public class ShiftClient implements IShiftClient {
    private Gson jsonSerializer;
    private String response;
    private HTTPHandler httpHandler;

    public ShiftClient(HTTPHandler httpHandler) {
        this.httpHandler = httpHandler;
    }

    @Override
    public String postShift(Shift shift) {
        String PATH ="http://127.0.0.1:5000/api/Shift";
        String shiftJson = jsonSerializer.toJson(shift);
        System.out.println(shiftJson);
        response = httpHandler.postToAPI(shiftJson, PATH);
        return response;
    }

    @Override
    public String getResponse() {
        return response;
    }
}