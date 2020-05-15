
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServer {

    public static void main(String[] args){
        IJDBCConnect connect = new JDBCConnect();
        connect.getConnection();
        connect.getInformation();
        DatabaseModel model = new DatabaseModelImpl(connect);
        System.out.println("Server started");
        try {
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
        }catch (IOException e) {
            System.out.println("Something went bad");
            e.printStackTrace();
        }
    }
}
