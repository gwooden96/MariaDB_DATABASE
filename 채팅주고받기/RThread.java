package 채팅주고받기;

import java.io.DataInputStream;
import java.net.Socket;

public class RThread extends Thread {
	
	private final Socket socket;

	public RThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
	String message;
	
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			while(true) {
				message = dis.readUTF();
				
				System.out.println("상대방 : " + message);
			}
		} catch (Exception e) {
			
	
		}
	}
	

}
