package model;

import shared.Shift;
import shared.User;

public interface DatabaseModel {
    String Login(User login);

    Shift[] getMonthOfShiftsByManager(String recievedPiece, String recievedPiece1);
}
