package 채팅주고받기;

import java.net.Socket;

public class SocketClientMain {

	public static void main(String[] args) {
		
		
		Socket socket = null;
		
		try {
			socket = new Socket("localhost", 5500);
			System.out.println("[연결 성공]");
		} catch (Exception e) {
			System.out.println("[연결실패]");
		}
		
		if(socket != null) {
			RThread rt = new RThread(socket);
			SThread st = new SThread(socket);
			
			rt.start();
			st.start();
			
		}

	}

}
