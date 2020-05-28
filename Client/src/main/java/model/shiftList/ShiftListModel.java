package model.shiftList;

import clientNetworking.shiftList.IShiftListClient;
import model.calendar.ICalendarModel;
import shared.Shift;

import java.util.ArrayList;

public class ShiftListModel implements IShiftListModel {
    private IShiftListClient client;
    private ICalendarModel calendarModel;
    private Shift forEditing;
    public ShiftListModel(ICalendarModel calendarModel, IShiftListClient client) {
        this.calendarModel = calendarModel;
        this.client = client;
    }

    @Override
    public ArrayList<Shift> getShifts() {
        return client.getCalendarShifts(calendarModel.getUserFromModel().getId(), calendarModel.getUserFromModel().getAccessLevel(), calendarModel.getTimeStamp() );
    }

    @Override
    public void saveShift(Shift seleced) {
        forEditing = seleced;
    }
    public void removeShift(int shiftId) {
        client.removeShift(shiftId);
    }
}
