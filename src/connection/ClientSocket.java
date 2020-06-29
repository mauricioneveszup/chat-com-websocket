package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String[] args) {
        try {
            final Socket client = new Socket("127.0.0.1",9999);

            new Thread(){
                @Override
                public void run(){
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        PrintWriter writer = new PrintWriter(client.getOutputStream());

                        while (true){
                            String message = reader.readLine();
                            System.out.println("server say: " + message);
                        }


                    }catch (IOException e){
                        System.out.println("Impossivel ler a mensagem do server:");
                        e.printStackTrace();
                    }
                }
            }.start();

            PrintWriter writer = new PrintWriter(client.getOutputStream());
            BufferedReader readerTerminal = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String messageTerminal = readerTerminal.readLine();
                writer.println(messageTerminal);
            }


        } catch (UnknownHostException e) {
            System.out.println("O Endereço informado esta incorreto.");
            e.printStackTrace();
        } catch (IOException e ){
            System.out.println("Servidor pode estar temporariamente fora do ar.");
            e.printStackTrace();
        }
    }
}
