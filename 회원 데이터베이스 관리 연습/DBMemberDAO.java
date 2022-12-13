package DB2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	
	//PreparedStatement 기능확장 (재사용면에서 매우 편리함) / 단점으로는 코드가 길어짐
	
	
	
	Connection conn = null;
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	
	//생성자
	public MemberDAO() {
		try { //마리아db 데이터베이스에 연결
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/javadb", "root", "java1234");
		} catch (Exception e) {
			e.printStackTrace(); // Driver를 못 찾았을때 예외처리
		}
	}
	
	/**메서드 생성*/
	
	//전체 레코드를 조회하는 메서드
	public List<MemberVO> list() { //객체들을 보관하기 위한 List 컬렉션 생성 (추가, 삭제 등으로 위한 컬레션을 사용하는게 좋음)
		List<MemberVO> list = new ArrayList<>(); //list에 담겨 있는 VO객체를 Main으로 보내 최종 작업
		
		try {
			String sql = "select * from member";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //
			
			while(rs.next()) {
		
							
				MemberVO vo = new MemberVO(); //빈 객체를 위에 list에 넣어줄 려고
				
				//set으로 호출 -> get으로 값을 MemberVO 클래스에 값을 보내 보관
				//VO 객체에 멤버변수가 저장
				vo.setMemberno(rs.getInt("memberno")); 
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				
				list.add(vo); //list에 다음값이 있을때 까지 반복해서 객체를 넣는다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
