package clientNetworking.calendar;

import clientNetworking.restEASY.HTTPHandler;
import com.google.gson.Gson;
import shared.Shift;
import shared.User;

public class CalendarClientImpl implements CalendarClient{
    private Gson jsonSerializer;
    private String response;
    private HTTPHandler httpHandler;


    public CalendarClientImpl(HTTPHandler httpHandler){
        this.httpHandler = httpHandler;
        this.jsonSerializer = new Gson();
    }

    @Override // date format xx-xxxx
    public Shift[] getCalendarShifts(String username, String month) {
        String PATH ="http://127.0.0.1:5000/api/Shifts/?username=" +  username + "&date=" + month;
        response = httpHandler.GetFromAPI(PATH);
        Shift[] shifts = jsonSerializer.fromJson(response, Shift[].class);
        return shifts;
    }

    @Override
    public String getResponse() {
        return null;
    }

    @Override
    public User getUser(String Id) {
        String PATH ="http://127.0.0.1:5000/api/Login/" +Id;
        response = httpHandler.GetFromAPI(PATH);
        User user = jsonSerializer.fromJson(response, User.class);
        return user;
    }
}
