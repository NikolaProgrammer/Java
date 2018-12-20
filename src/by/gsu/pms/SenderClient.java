package by.gsu.pms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SenderClient {

	public static void main(String[] args) {
		final String HOST = "localhost";
		final int PORT = 8080;
		
		try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			Socket socket = new Socket(HOST, PORT);
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			String message = in.readLine();
			pw.println(message);
		} catch(IOException e) {
			System.err.println(e);
		}
	}

}
