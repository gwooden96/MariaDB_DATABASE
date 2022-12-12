package 채팅주고받기;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerMain {

	public static void main(String[] args) throws Exception {
		
		
		ServerSocket serverSocket = new ServerSocket(5500);
		
		while(true) {
			Socket socket = serverSocket.accept();
			System.out.println("ip : " + socket.getInetAddress() + "와 연결 성공");
			
			
			//송수신 쓰레드
			
			ReceiveTread rt = new ReceiveTread(socket);
			SendThread st = new SendThread(socket);
			
			rt.start();
			st.start();
		}

	}

}
