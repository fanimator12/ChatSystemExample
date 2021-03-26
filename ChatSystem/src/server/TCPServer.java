package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPServer
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 5678;

    ServerSocket welcomeSocket = new ServerSocket(PORT);

    while(true){
      try{
        System.out.println("connect");

        Socket socket = welcomeSocket.accept();
        System.out.println("Connected");

        String client = socket.getInetAddress().getHostAddress();
        System.out.println(client);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String string = in.readLine();
        System.out.println(string);

        out.println(string);

      }catch(UnknownHostException e){
        System.out.println("Disconnected");
        e.printStackTrace();
        welcomeSocket.close();
      }
    }
  }
}
