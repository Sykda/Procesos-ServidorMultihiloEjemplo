package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public static void main(String[] args) throws IOException {
        
        try (ServerSocket socket = new ServerSocket(2880)) {
            System.out.println("El servidor esta corriendo...");
            
            while(true){

                Socket cliente = socket.accept();
                new Thread(new Session(cliente)).start();;
            }
        }
    }
}
