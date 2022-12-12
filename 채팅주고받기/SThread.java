package 채팅주고받기;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SThread extends Thread{
	
	private final Socket socket;
	Scanner sc = new Scanner(System.in);
	
	
	public SThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		String message;
		
		try {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			while(true) {
				message = sc.nextLine();
				
				dos.writeUTF(message);
				dos.flush();
			}
			
		}catch (Exception e) {
			
		}
	
	}

}
