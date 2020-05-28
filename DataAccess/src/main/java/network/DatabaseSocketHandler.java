package network;

import com.google.gson.Gson;
import persistence.DAOFactory;
import shared.Shift;
import shared.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
                    int serial = Integer.parseInt(receivedPieces[2]);
                    User login = gson.fromJson(receivedPieces[1], User.class);
                    String confirmation = daoFactory.getLoginDAO().validateLogin(login);
                    sendToClient(confirmation, serial);
                }
                else if(receivedPieces[0].equals("CalendarMonth")) {
                    int serial = Integer.parseInt(receivedPieces[3]);
                    String[] date = receivedPieces[2].split("-");
                    ArrayList<Shift> shiftsForMonth = new ArrayList<>();
                    // Inputs are :Username for first input, month in MM-yyyy format
                    if(receivedPieces[3].equals("EMPLOYEE")){
                        shiftsForMonth = daoFactory.getShiftDAO().getShifts(receivedPieces[1], date[0], date[1]);
                    }else if(receivedPieces[3].equals("MANAGER")){
                        shiftsForMonth = daoFactory.getShiftDAO().getShiftsManager(receivedPieces[1], date[0], date[1]);
                    } else {
                        System.out.println("Problem in determening access level");
                    }
                    String shiftsJson = gson.toJson(shiftsForMonth);
                    sendToClient(shiftsJson, serial);
                }
                else if(receivedPieces[0].equals("GetUser")) {
                    int serial = Integer.parseInt(receivedPieces[2]);
                    User user = daoFactory.getUserDAO().getUser(receivedPieces[1]);
                    String userJson = gson.toJson(user);
                    sendToClient(userJson, serial);
                }
                else if(receivedPieces[0].equals("PostUser")) {
                    if(!receivedPieces[1].equals("Confirmed")){
                        int serial = Integer.parseInt(receivedPieces[2]);
                        User new_user = gson.fromJson(receivedPieces[1], User.class);
                        String addResponse = daoFactory.getUserDAO().addUser(new_user,"Check");
                        sendToClient(addResponse, serial);
                    } else {
                        int serial = Integer.parseInt(receivedPieces[3]);
                        User new_user = gson.fromJson(receivedPieces[2], User.class);
                        String addResponse = daoFactory.getUserDAO().addUser(new_user,"Post");
                        sendToClient(addResponse, serial);
                    }
                }
                else if (receivedPieces[0].equals("PostShift")) {
                    if(!receivedPieces[1].equals("Confirmed")){
                        int serial = Integer.parseInt(receivedPieces[2]);
                        Shift new_shift = gson.fromJson(receivedPieces[1], Shift.class);
                        String addResponse = daoFactory.getShiftDAO().postShift(new_shift,"Check");
                        sendToClient(addResponse, serial);
                    } else {
                        int serial = Integer.parseInt(receivedPieces[3]);
                        Shift new_shift = gson.fromJson(receivedPieces[2], Shift.class);
                        String addResponse = daoFactory.getShiftDAO().postShift(new_shift,"Post");
                        sendToClient(addResponse, serial);
                    }
                }
                else if (receivedPieces[0].equals("updateShift")) {
                    if(!receivedPieces[1].equals("Confirmed")){
                        int serial = Integer.parseInt(receivedPieces[2]);
                        Shift new_shift = gson.fromJson(receivedPieces[1], Shift.class);
                        String addResponse = daoFactory.getShiftDAO().updateShift(new_shift,"Check");
                        sendToClient(addResponse, serial);
                    } else {
                        int serial = Integer.parseInt(receivedPieces[3]);
                        Shift new_shift = gson.fromJson(receivedPieces[2], Shift.class);
                        String addResponse = daoFactory.getShiftDAO().updateShift(new_shift,"Post");
                        sendToClient(addResponse, serial);
                    }
                }
                else if(receivedPieces[0].equals("GetUsersIDName")) {
                    int serial = Integer.parseInt(receivedPieces[2]);
                    List<User> users_id_name = daoFactory.getUserDAO().getUsersIdName(receivedPieces[1]);
                    String userJson = gson.toJson(users_id_name);
                    sendToClient(userJson, serial);
                }
                else if(receivedPieces[0].equals("GetManagedUsers")){
                    int serial = Integer.parseInt(receivedPieces[2]);
                    List<User> managedUsers = daoFactory.getUserDAO().getUsersByManager(receivedPieces[1]);
                    String userJson = gson.toJson(managedUsers);
                    sendToClient(userJson, serial);
                }
                else if(receivedPieces[0].equals("DeleteUser")){
                    int serial = Integer.parseInt(receivedPieces[2]);
                    String response = daoFactory.getUserDAO().deleteUser(receivedPieces[1]);
                    sendToClient(response, serial);
                } else if(receivedPieces[0].equals("DeleteShift")){
                    int serial = Integer.parseInt(receivedPieces[2]);
                    String response = daoFactory.getShiftDAO().deleteShift(receivedPieces[1]);
                    sendToClient(response, serial);
                }
            }
        }catch (Exception e){ //VIOLATION OF SOLID
            e.printStackTrace();
        }
    }

    public void sendToClient(String toSend, int serial){
        toSend = toSend+serial;
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
