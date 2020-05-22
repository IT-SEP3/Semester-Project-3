package persistence.shift;

import shared.Shift;

import java.util.ArrayList;

public interface IShiftDAO {
    String postShift(Shift shift);
    ArrayList<Shift> getShifts(String userID, String month, String year);
}
