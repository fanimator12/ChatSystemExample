package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class TCPClient
{
  public static void main(String[] args) throws UnknownHostException, IOException
  {
    final int PORT = 5678;
    final String HOST = "localhost";
    ArrayList<String> log = new ArrayList<String>();

    Scanner keyboard = new Scanner(System.in);

    Socket socket = new Socket(HOST, PORT);

    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

    do {
      String string = keyboard.nextLine();
      log.add(string);
      out.println(string);
    } while(keyboard.nextLine().equals("exit"));
  }
}
