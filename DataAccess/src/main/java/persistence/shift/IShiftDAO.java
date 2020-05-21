package persistence.shift;

import shared.Shift;
import shared.User;

import java.util.ArrayList;

public interface IShiftDAO {

    ArrayList<Shift> getShifts(String userID, String month, String year);
}
