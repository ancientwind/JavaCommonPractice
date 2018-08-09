package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GreetClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        GreetClient client = new GreetClient();
        client.startConnection("localhost", 8080);
        String resp = client.sendMessage("hello from client 1");
        System.out.println("from server: " + resp);
//        String resp2 = client.sendMessage("hello server");
//        System.out.println("from server: " + resp2);
        GreetClient client2 = new GreetClient();
        client2.startConnection("localhost", 8080);
        String resp2 = client.sendMessage("hello from client 2");
        System.out.println("from server: " + resp2);

    }
}
