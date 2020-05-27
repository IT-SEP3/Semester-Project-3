package viewModel.shiftList;

import model.addshift.IAddShiftModel;
import model.employeeList.IEmployeeListModel;
import model.shiftList.IShiftListModel;
import shared.Shift;

import java.util.ArrayList;

public class ShiftListViewModel {
    private IShiftListModel model;

    public ShiftListViewModel(IShiftListModel shiftListModel) {
        this.model = shiftListModel;
    }

    public ArrayList<Shift> populateListView() {
        return model.getShifts();
    }
}
