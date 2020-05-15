package ClientNetworking;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*


ONLY A PLACE HOLDER NOT THE ACCTUAL CLIENT NETWORK HANDLER



 */
public class ClientSocketHandler implements Runnable{

    private ObjectInputStream inFromServer;
    private ObjectOutputStream outToServer;

    public ClientSocketHandler(ObjectOutputStream outToClient, ObjectInputStream inFromClient){
        this.outToServer = outToClient;
        this.inFromServer = inFromClient;
    }
    @Override
    public void run() {

    }

    public void Login(String json){

    }
}
