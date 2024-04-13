package org.example.echoServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try{
            System.out.println("Waiting for clients...");
            ServerSocket serverSocket = new ServerSocket(80);
            Socket socket = serverSocket.accept();
            System.out.println("Connection established");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String string = in.readLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println("Server says:"+string);


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}