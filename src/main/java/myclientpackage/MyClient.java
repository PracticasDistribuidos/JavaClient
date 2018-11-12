package myclientpackage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import myclientpackage.requests.SelectNick;

import java.net.*;

public class MyClient {

    public static void main(String[] args) {
        DatagramSocket socket;
        try {
            /*---------------------- Send -----------------------------*/
            socket = new DatagramSocket();
            SelectNick nick = new SelectNick("Elgabo311");

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String msg = (gson.toJson(nick));

            byte [] b = msg.getBytes();
            InetAddress host = InetAddress.getByName("localhost");
            int serverSocket = 6788;
            DatagramPacket request = new DatagramPacket(b,b.length,host,serverSocket);
            socket.send(request);

            /*---------------------- Receive -----------------------------*/
            byte [] buffer = new byte[1024];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            socket.receive(reply);
            System.out.println("Client received: \n " + new String(reply.getData()).substring(0,reply.getLength()));
            socket.close();
        } catch (Exception ex) {

        }
    }
}