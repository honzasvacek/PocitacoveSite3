import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException, IOException {
        Server();

    }
    public static void Server() throws IOException {
        String request;
        System.out.println("krok 1");
        ServerSocket server = new ServerSocket(10000);

        while(true){
            //čekám až se na server neěkdo připojí
            Socket socket = server.accept();
            System.out.println("Připojeno na server");

            //získáni IP adresy klienta
            InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            String clientIpAddress = socketAddress.getAddress().getHostAddress();

            //získání vstupu klienta
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            request = in.readLine();

            //vypsání vstupu a IP adresy
            System.out.println("request from " + clientIpAddress + " : " + request);


        }
    }
}