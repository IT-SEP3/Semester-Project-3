package model;

import shared.Shift;
import shared.User;
import exceptions.DataConnectionException;

public interface DatabaseModel {
    String Login(User login) throws DataConnectionException;

    Shift[] getMonthOfShiftsByManager(String recievedPiece, String recievedPiece1);
}
