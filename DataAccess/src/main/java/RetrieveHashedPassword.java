import java.util.Scanner;

public class RetrieveHashedPassword {

    public static void main(String[] args) {

        String password = "test"; //Write your password here

        System.out.println("\nHashed value of " + "'" + password + "'" + " is: " + password.hashCode());
    }
}
