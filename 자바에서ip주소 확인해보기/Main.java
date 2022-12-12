package 주소;

import java.net.InetAddress;

public class Main {

	public static void main(String[] args) {
		
		try {
		InetAddress local = InetAddress.getLocalHost(); //예외발생할 경우가 있을 수 있으므로 예외처리 필요
		System.out.println("내컴퓨터  ip 주소 : " + local.getHostAddress());
		
		InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
		for(InetAddress r : iaArr) {
			System.out.println("네이버 ip 주소 : " + r.getHostAddress());
		}
		
		}catch (Exception e) {
			
		}
		

	}

}
