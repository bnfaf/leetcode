package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;

public class Client {
    public static void main(String[] args) throws IOException {
        String readline = null;
        String inTemp = null;
        String turnLine = "\n";
        final String client = "Client: ";
        final String server = "Server: ";
        int port = 4000;
        byte[] ipAddress = {127, 0, 0, 1};
        InetAddress inetAddress = InetAddress.getByAddress(ipAddress);
        Socket socket = new Socket(inetAddress, port);
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
        while (!Objects.equals(readline, "bye")){
            System.out.println(client);
            readline = systemIn.readLine();
            socketOut.println(readline);
            socketOut.flush();
            inTemp = socketIn.readLine();
            System.out.println(server + turnLine + inTemp);
        }
        systemIn.close();
        socketIn.close();
        socketOut.close();
        socket.close();
    }
}
