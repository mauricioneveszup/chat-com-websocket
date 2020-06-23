package connection;

import application.ClientManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        try {
            System.out.println("init start server");
            server = new ServerSocket(9999);
            System.out.println("Server Started");
            while(true){
                Socket socket = server.accept();
                new ClientManager(socket);
            }
        } catch (IOException e) {
            System.err.println("The door 9999 it is occupied or the server is close ");
            Objects.requireNonNull(server);
            server.close();
            e.printStackTrace();
        }
    }
}
