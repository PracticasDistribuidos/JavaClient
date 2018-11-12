package myclientpackage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import myclientpackage.requests.Exit;
import myclientpackage.requests.ListUsers;
import myclientpackage.requests.SelectNick;

import javax.xml.crypto.Data;
import java.net.*;
import java.util.concurrent.TimeUnit;

public class MyClient {


    public static void main(String[] args) {
        DatagramSocket socket;
        try {
            socket = new DatagramSocket();
            SelectNick nick = new SelectNick("Elgabo311");
            ListUsers listusers = new ListUsers();
            Exit exit = new Exit();

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            //Entrar con nick de Elgabo311
            String msg = (gson.toJson(nick));
            sendMessage(msg, socket);
            TimeUnit.SECONDS.sleep(1);
            receiveMessage(socket);

            //Ver usuarios conectados
            msg = (gson.toJson(listusers));
            sendMessage(msg, socket);
            TimeUnit.SECONDS.sleep(1);
            receiveMessage(socket);

            //Salir
            msg = (gson.toJson(exit));
            sendMessage(msg, socket);
            TimeUnit.SECONDS.sleep(1);
            receiveMessage(socket);

            //Volver a entrar con el mismo nick
            /*msg = (gson.toJson(nick));
            sendMessage(msg, socket);
            TimeUnit.SECONDS.sleep(3);
            receiveMessage(socket);
            */

            socket.close();
        } catch (Exception ex) {

        }
    }

    public static void sendMessage(String msg, DatagramSocket socket) {
        try {
            byte[] b = msg.getBytes();
            InetAddress host = InetAddress.getByName("localhost");
            int serverSocket = 6788;
            DatagramPacket request = new DatagramPacket(b, b.length, host, serverSocket);
            socket.send(request);
        }
        catch (Exception e) {

        }
    }

    public static void receiveMessage(DatagramSocket socket) {
        try {
            byte[] buffer = new byte[1024];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            socket.receive(reply);
            System.out.println("Mensaje Recibido: \n " + new String(reply.getData()).substring(0, reply.getLength()));
        } catch (Exception E) {

        }

    }
}