package by.gsu.pms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Connect extends Thread {
	private Socket inputSocket;
	private Socket outSocket;

	Connect(Socket inputSock){
		inputSocket = inputSock;
		setPriority(NORM_PRIORITY - 1);
		start();
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputSocket.getInputStream()));
			String message = reader.readLine();
			System.out.println("receiver: " + message);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
}
