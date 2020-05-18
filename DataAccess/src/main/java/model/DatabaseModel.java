package Model;

import Shared.Shift;
import Shared.User;
import exceptions.DataConnectionException;

public interface DatabaseModel {
    String Login(User login) throws DataConnectionException;

    Shift[] getMonthOfShiftsByManager(String recievedPiece, String recievedPiece1);
}
