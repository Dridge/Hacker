package richard.eldridge.hacker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Hacker {
	private static final int PORT_NUMBER = 63458;
	private Socket socket;

	public Hacker(){
		try {
			socket = new Socket("localhost", PORT_NUMBER);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println("NFriend");
			out.println("BFriend Do you want to buy some swamp land?");
			while(true) {
				String input = in.readLine();
				System.out.println(input);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		try {
			if(socket != null) {
				socket.close();
			} 
		} catch(IOException e) {
			//Do nothing
		}
	}

	public static void main(String[] args) {
		Hacker hacker = new Hacker();
		
	}

}
