package model.addshift;

import clientNetworking.shift.IShiftClient;
import model.login.ILoginModel;
import shared.Shift;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class AddShiftModel implements IAddShiftModel {

    public IShiftClient client;
    private ILoginModel loginModel;
    private HashMap<String, Integer> userMap;

    public AddShiftModel(IShiftClient client, ILoginModel loginModel) {
        this.client = client;
        this.loginModel = loginModel;
    }

    public ArrayList<String> getUsers() {
        userMap = client.getUsers();
        Set<String> names = userMap.keySet();
        ArrayList<String> listOfNames = new ArrayList<String>(names);
        return listOfNames;
    }

    public String addShift(String description, String employeeName, LocalDate date) {
        int manager_id = loginModel.getCurrentUser().getId();
        int user_id = userMap.get(employeeName);
        Shift tmp_shift = new Shift(user_id, description, manager_id, date);
        String api_response = client.postShift(tmp_shift);
        System.out.println(api_response);
        return api_response;
    }
}
