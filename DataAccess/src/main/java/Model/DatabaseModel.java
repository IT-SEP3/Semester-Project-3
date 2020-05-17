package Model;

import Shared.Shift;
import Shared.User;

public interface DatabaseModel {
    String Login(User login);

    Shift[] getMonthOfShiftsByManager(String recievedPiece, String recievedPiece1);
}
