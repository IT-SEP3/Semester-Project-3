package network;

import persistence.DAOFactory;
import shared.Shift;
import shared.User;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class DatabaseSocketHandler implements Runnable {
    private Socket socket;
    private OutputStream outToClient;
    private InputStream inFromClient;
    private DAOFactory daoFactory;
    private Gson gson;

    public DatabaseSocketHandler(Socket socket, DAOFactory daoFactory){
        this.socket = socket;
        this.daoFactory = daoFactory;
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
                String[] receivedPieces = received.split(";");

                if(receivedPieces[0].equals("Login")){
                    User login = gson.fromJson(receivedPieces[1], User.class);
                    String confirmation = daoFactory.getLogin().validateLogin(login);
                    sendToClient(confirmation);
                }

                else if(receivedPieces[0].equals("CalendarMonth")) {
                    String[] date = receivedPieces[2].split("-");
                    ArrayList<Shift> shiftsForMonth = new ArrayList<>();
                    // Inputs are :Username for first input, month in somekind of 05/2020 format
                    if(receivedPieces[3].equals("EMPLOYEE")){
                        System.out.println("Getting employee");
                        shiftsForMonth = daoFactory.getShift().getShifts(receivedPieces[1], date[0], date[1]);
                    }else if(receivedPieces[3].equals("MANAGER")){
                        System.out.println("Getting manager");
                        shiftsForMonth = daoFactory.getShift().getShiftsManager(receivedPieces[1], date[0], date[1]);
                    } else {
                        System.out.println("Problem in determening access level");
                    }

                    String shiftsJson = gson.toJson(shiftsForMonth);
                    sendToClient(shiftsJson);
                }
                else if(receivedPieces[0].equals("GetUser")) {
                    System.out.println("trying to get user data");
                    User user = daoFactory.getEmployee().getUser(receivedPieces[1]);
                    String userJson = gson.toJson(user);
                    sendToClient(userJson);
                }
                else if(receivedPieces[0].equals("AddUser")) {
                    User new_user = gson.fromJson(receivedPieces[1], User.class);
                    String addResponse = daoFactory.getEmployee().addEmployee(new_user);
                    sendToClient(addResponse);
                }
                else if (receivedPieces[0].equals("AddShift")) {
                    Shift new_shift = gson.fromJson(receivedPieces[1], Shift.class);
                    String addResponse = daoFactory.getShift().postShift(new_shift);
                    sendToClient(addResponse);
                }
            }
        }catch (Exception e){ //VIOLATION OF SOLID
            e.printStackTrace();
        }
    }

    public void sendToClient(String toSend){
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
