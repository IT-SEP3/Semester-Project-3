package clientNetworking.calendar;

import clientNetworking.restEASY.HTTPHandler;
import com.google.gson.Gson;
import shared.Shift;

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
        String TestPATH ="http://127.0.0.1:5000/api/Login/?username=" +  username + "&date=" + month;
        response = httpHandler.GetFromAPI(TestPATH);

        return new Shift[0];
    }

    @Override
    public String getResponse() {
        return null;
    }
}
