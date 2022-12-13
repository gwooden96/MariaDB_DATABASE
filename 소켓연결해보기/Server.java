package 소켓연결해보기;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

   public static void main(String[] args) {
      ServerSocket serverSocket = null;

      try {
         serverSocket = new ServerSocket();
         serverSocket.bind(new InetSocketAddress("localHost", 5001));

         while (true) {
            System.out.println("[연결대기]");
            Socket socket = serverSocket.accept();

            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            System.out.println("[연결수락] : " + isa.getHostName());

            byte[] bytes = null;
            String message= null;
            
            InputStream is= socket.getInputStream();
            bytes = new byte[100];
            int readByteCount = is.read(bytes);
            message = new String(bytes,0,readByteCount,"utf-8"); 
            System.out.println("[데이터 받음]"+message);
            
            OutputStream os= socket.getOutputStream();
            message = "hi Client";
            bytes = message.getBytes("utf-8");
            os.write(bytes);
            os.flush();
            System.out.println("[데이터 전송함]");
            
            is.close();
            os.close();
            socket.close();
         }
      } catch (Exception e) {
         System.out.println("[연결실패]");
      }
      if (!serverSocket.isClosed()) {
         try {
            serverSocket.close();
         } catch (Exception e) {

         }
      }
   }

}