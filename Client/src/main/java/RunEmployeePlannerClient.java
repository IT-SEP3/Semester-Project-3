import javafx.application.Application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RunEmployeePlannerClient {

    public static void main(String[] args) throws ParseException {
        //Application.launch(EmployeePlannerApp.class);
        String input_date="19/05/2020";
        SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
        Date dt1=format1.parse(input_date);
        DateFormat format2=new SimpleDateFormat("EEEE");
        String finalDay=format2.format(dt1);
        System.out.println(finalDay);
    }
}
