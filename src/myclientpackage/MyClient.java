package myclientpackage;
import java.net.*;

public class MyClient {

    public static void main(String[] args) {
        DatagramSocket socket;
        try {
            /*---------------------- Send -----------------------------*/
            socket = new DatagramSocket();
            String msg = "test message ";
            byte [] b = msg.getBytes();
            InetAddress host = InetAddress.getByName("localhost");
            int serverSocket = 6788;
            DatagramPacket request = new DatagramPacket(b,b.length,host,serverSocket);
            socket.send(request);

            /*---------------------- Receive -----------------------------*/
            byte [] buffer = new byte[1024];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            socket.receive(reply);
            System.out.println("Client received: \n " + new String(reply.getData()));
            socket.close();
        } catch (Exception ex) {

        }
    }
}