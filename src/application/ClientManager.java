package application;

import java.io.*;
import java.net.Socket;

public class ClientManager extends Thread {

    private Socket client;

    public ClientManager(Socket client){
        this.client = client;
        start();
    }

    @Override
    public void run() {
        try {
            BufferedReader reader =  new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter writer = new PrintWriter(client.getOutputStream());
        } catch (IOException e) {
            System.err.println("Client close connection");
            e.printStackTrace();
        }


        //client.getInputStream();
    }
}
