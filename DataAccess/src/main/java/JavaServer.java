package main.java;

import main.java.exceptions.DataConnectionException;
import main.java.model.DatabaseModel;
import main.java.model.DatabaseModelImpl;
import main.java.network.DatabaseSocketHandler;
import main.java.persistence.database.DBConnection;
import main.java.persistence.database.IDBConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServer {

    public static void main(String[] args){
        IDBConnection connect = new DBConnection();
        DatabaseModel model = new DatabaseModelImpl(connect);
        System.out.println("Server started");
        try {
            connect.getConnection();
            ServerSocket serverSocket = new ServerSocket(4343, 10);
            int i = 0;
            //
            //connect.getConnection();
            //connect.getInformation();
            while(true){
                Socket connectionSocket = serverSocket.accept();
                DatabaseSocketHandler c = new DatabaseSocketHandler(connectionSocket, model);
                new Thread(c, "Business Server " + i).start();
                System.out.println("Connected to Business server " + i);
                i++;
            }
        }catch (IOException | DataConnectionException e) {
            System.out.println("Something went bad");
            e.printStackTrace();
        }
    }
}
