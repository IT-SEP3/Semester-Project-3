package ClientNetworking;

import ClientNetworking.restEASY.HTTPHandler;
import Shared.User;
import com.google.gson.Gson;

import javax.xml.ws.Response;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientImp implements ClientNetworking.Client {
    private Gson jsonSerializer;
    private String response;
    private ClientSocketHandler socketHandler;
    private HTTPHandler httpHandler;


    public ClientImp(HTTPHandler httpHandler){
        this.httpHandler = httpHandler;

        // TESTING FOR RESPONSE OF SERVER NOT WORKING NOT ACTUAL SERVER CODE. FREE TO DELETE
        try {
            Socket socket = new Socket("localhost", 3000);
            socketHandler = new ClientSocketHandler(
                    new ObjectOutputStream(socket.getOutputStream()),
                    new ObjectInputStream(socket.getInputStream())
            );
            Thread t = new Thread(socketHandler);
            t.start();
        }catch (Exception e) {
            response = "Server down";
            e.printStackTrace();
        }
        // ===================================================
        this.jsonSerializer = new Gson();
    }

    @Override
    public void Login(User loginCarrier) {
        String PATH ="http://127.0.0.1:5000/api/Login";
        String loginJson = jsonSerializer.toJson(loginCarrier);
        response = httpHandler.SendToAPI(loginJson, PATH);
        System.out.println(loginJson);
    }

    @Override
    public String getResponse() {
        return response;
    }
}
