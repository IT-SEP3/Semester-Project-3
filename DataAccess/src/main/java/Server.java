package main.java;


import main.java.persistence.database.DBConnection;
import main.java.persistence.exceptions.DataConnectionException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(1010, 1);
            int i = 0;
            DBConnection connection = new DBConnection();
            connection.getConnection();
            while (true) {
                Socket socket1 = socket.accept();

            }


        } catch (IOException | DataConnectionException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
}
