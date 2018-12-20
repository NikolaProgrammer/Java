package by.gsu.pms;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	public static void main(String[] args) {
		final int INPUT_PORT = 8080;
		try {
			ServerSocket inputSocket = new ServerSocket(INPUT_PORT);
			while(true) {
				new Connect(inputSocket.accept());
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
