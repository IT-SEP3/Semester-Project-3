package clientNetworking.shiftList;

import shared.Shift;

import java.util.ArrayList;

public interface IShiftListClient {
    ArrayList<Shift> getCalendarShifts(int userID, String accessLevel, String month);
    String removeShift(int shiftId);
    String getResponse();
}
