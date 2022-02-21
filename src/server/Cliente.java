package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {

        Socket cliente = new Socket("127.0.0.1", 2880);        

        DataOutputStream dos= new DataOutputStream(cliente.getOutputStream());

        for (int i = 0; i < 4; i++) {
            
            dos.writeBytes("hola\n");

            //Thread.sleep(000);
        }

        dos.writeBytes("adios\n");
        cliente.close();
        

    }
}
