package 채팅주고받기;

import java.io.DataInputStream;
import java.net.Socket;

public class ReceiveTread extends Thread {
	
	private final Socket socket;

	public ReceiveTread(Socket socket) {
		this.socket = socket;
	}
	
	/**계속 받을 수 있게 해주는 run 스레드*/
	public void run() {
		try {
			//DataInputStream <-- 보조 스트림 (socket.getInputStream())
			DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());
			String message; //문자를 받는 변수 선언
			
			while(true) { //문자를 받을때 마다 무한 반복
				message = tmpbuf.readUTF(); //문자를 읽어올때는 readUTF 사용
				System.out.println("상대방 : " + message);
			}
		} catch (Exception e) {
			
			System.out.println("[연결종료]");
		}
		
	}
	

}
