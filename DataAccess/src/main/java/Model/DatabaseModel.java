package main.java.Model;
import main.java.Shared.Shift;
import main.java.Shared.User;
public interface DatabaseModel {
    String Login(User login);

    Shift[] getMonthOfShiftsByManager(String recievedPiece, String recievedPiece1);
}
