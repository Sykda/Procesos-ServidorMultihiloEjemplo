package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Session implements Runnable {

    Socket socket;

    public Session(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            // Lector
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));            

            while (true) {

                String linea= br.readLine();
                
                if (linea.equalsIgnoreCase("adios"))
                    break;

                System.out.println(
                        "Cliente conectado en el puerto: " + socket.getPort());
                System.out.println("Cliente dice: " + linea);

            }

            System.out.println("Cliente desconectado");

        } catch (IOException e) {

            System.out.println("Error en buffered reader");

        }
    }

}
