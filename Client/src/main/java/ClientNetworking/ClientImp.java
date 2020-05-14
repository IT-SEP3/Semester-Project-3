package ClientNetworking;

import Shared.User;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientImp implements ClientNetworking.Client {
    private Gson jsonSerializer;
    private String response;
    private ClientSocketHandler socketHandler;


    public ClientImp(){
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
        this.jsonSerializer = new Gson();
    }

    @Override
    public void Login(User loginCarrier) {
        String json = jsonSerializer.toJson(loginCarrier);
        System.out.println(json);
        System.out.println(response);
        //socketHandler.Login(json);
    }

    @Override
    public String getResponse() {
        return response;
    }
}
