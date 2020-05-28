package model.shiftList;

import shared.Shift;

import java.util.ArrayList;

public interface IShiftListModel {
    ArrayList<Shift> getShifts();

    void saveShift(Shift seleced);
}
