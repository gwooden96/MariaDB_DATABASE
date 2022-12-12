package DB;

import java.util.List;

public class MemberMain {

	public static void main(String[] args) {
		
		//insert 추가할 데이터를 저장하는 객체
		MemberVO vo = new MemberVO();
		vo.setMemberno(3);
		vo.setId("asc");
		vo.setName("나로우");
		
		MemberDAO dao = new MemberDAO();
		
		int r = dao.insert(vo);
	
		if(r > 0) {
			System.out.println("회원 등록 성공");
		}
		
		//select 검색된 결과를 저장하는 객체
		MemberVO rvo = new MemberVO();
		rvo = dao.selectOne(3);
		
		System.out.println("==정보출력==");
		System.out.println("번호 : " + rvo.getMemberno());
		System.out.println("아이디 : " + rvo.getId());
		System.out.println("이름 : " + rvo.getName());
		
		System.out.println();
		
		System.out.println("===전체회원 정보===");
		List<MemberVO> list = dao.list();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("번호 : " + list.get(i).getMemberno() +
					"\t 아이디 : " + list.get(i).getId() +
					"\t 이름 : " + list.get(i).getName());
		}
		
		
		/** 삭제 기능 사용 후 정보 출력 */
		r = dao.delete(5);
		if(r > 0) {
			System.out.println("삭제 성공");
		}
		
		System.out.println("===전체회원 정보===");
		list = dao.list();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("번호 : " + list.get(i).getMemberno() +
					"\t 아이디 : " + list.get(i).getId() +
					"\t 이름 : " + list.get(i).getName());
		}
		
		//update
		vo.setMemberno(3); //변경할 멤버번호
		vo.setId("zxc"); //id를 저렇게 바꾸겠다
		vo.setName("gggg"); //name을 저렇게 바꾸겠다
		
		r = dao.update(vo);
		if(r > 0) {
			System.out.println("수정완료");
		}
		
		
		System.out.println("===전체회원 정보===");
		list = dao.list();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("번호 : " + list.get(i).getMemberno() +
					"\t 아이디 : " + list.get(i).getId() +
					"\t 이름 : " + list.get(i).getName());
		}
		
		dao.close();

	}

}
