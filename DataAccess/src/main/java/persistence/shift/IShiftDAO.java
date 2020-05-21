package persistence.shift;

import shared.Shift;

import java.util.ArrayList;

public interface IShiftDAO {

    String retrieveShifts(Shift shift);

    ArrayList<Shift> getShifts(Shift shift);
}
