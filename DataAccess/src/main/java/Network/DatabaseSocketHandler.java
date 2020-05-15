package main.java.Network;

import main.java.Model.DatabaseModel;
import com.google.gson.Gson;
import main.java.Shared.User;

import java.io.*;
import java.net.Socket;

public class DatabaseSocketHandler implements Runnable {
    private Socket socket;
    private OutputStream outToClient;
    private InputStream inFromClient;
    private DatabaseModel model;
    private Gson gson;

    public DatabaseSocketHandler(Socket socket, DatabaseModel model){
        this.socket = socket;
        this.model = model;
        gson = new Gson();
        try {
            inFromClient = socket.getInputStream();
            outToClient = socket.getOutputStream();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                byte[] lenBytes = new byte[4];
                inFromClient.read(lenBytes, 0, 4);
                int len = (((lenBytes[3] & 0xff) << 24) | ((lenBytes[2] & 0xff) << 16) |
                        ((lenBytes[1] & 0xff) << 8) | (lenBytes[0] & 0xff));
                byte[] receivedBytes = new byte[len];

                inFromClient.read(receivedBytes, 0, len);
                String received = new String(receivedBytes, 0, len);
                String[] recievedPieces = received.split(";");

                if(recievedPieces[0].equals("Login")){
                    User login = gson.fromJson(recievedPieces[1], User.class);
                    User logedInUser = model.Login(login);
                    sendToClient(logedInUser);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendToClient(Object received){
        String toSend = "Echo: " + gson.toJson(received);
        try {
            byte[] toSendBytes = toSend.getBytes();
            int toSendLen = toSendBytes.length;
            byte[] toSendLenBytes = new byte[4];
            toSendLenBytes[0] = (byte)(toSendLen & 0xff);
            toSendLenBytes[1] = (byte)((toSendLen >> 8) & 0xff);
            toSendLenBytes[2] = (byte)((toSendLen >> 16) & 0xff);
            toSendLenBytes[3] = (byte)((toSendLen >> 24) & 0xff);
            outToClient.write(toSendLenBytes);
            outToClient.write(toSendBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}