package clientNetworking.shift;

import clientNetworking.HTTPHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import shared.Shift;

import java.lang.reflect.Type;
import java.util.HashMap;

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

    @Override
    public HashMap<String, Integer> getUsers() {
        String PATH ="http://127.0.0.1:5000/api/Shift/Users";
        System.out.println("Getting users available for shifts");
        response = httpHandler.getFromAPI(PATH);

        Type type = new TypeToken<HashMap<String, String>>(){}.getType();
        HashMap<String, Integer> userMap = jsonSerializer.fromJson(response, type);
        return userMap;
    }
}
