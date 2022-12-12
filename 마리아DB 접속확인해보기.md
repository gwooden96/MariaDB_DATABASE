# **마리아DB 커넥션 JAR 파일이 잘 연동됐는지 확인해보는 코드 수식**

```java

package DB연결;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = null; //연결해주는 커넥션 객체 생성
		
		try {
			/**아래 고정 코드(계속 사용 예정) */
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/javadb", "root", "java1234");
			
	
			
		} catch (Exception e) {
			
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(Exception e) {

				}
			}
			
		}
		
		if(conn != null)
			System.out.println("데이터베이스 접속");

	}

}

```

<br>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcMYcm1%2FbtrTmYPTgLH%2FNkDLgGMMIem6MTL8IkimN1%2Fimg.png" width="700" height="100">