package DB2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //입력문
		MemberDAO dao = new MemberDAO(); //DAO메서드를 가져다 쓰기 위해 객체 생성
		int menu; //입력한 메뉴 번호 저장 변수
		
		System.out.println("===회원관리 프로그램===");
		
		while(true) {
			System.out.print("메뉴선택[1.회원목록]");
			menu = sc.nextInt();
			
			switch(menu) {
			
				case 1: 
					List<MemberVO> list = new ArrayList<>(); // return된 컬렉션을 저장하는 공간
					list = dao.list(); // 메서드 호출 결과를 list에 저장
					
					//위 컬렉션을 이렇게 한번에 코드입력도 가능List<MemberVO> list = dao.list();
					
					for(int i = 0; i < list.size(); i++) {
						System.out.print("번호 : " + list.get(i).getMemberno() + "\t");
						System.out.print("아이디 : " + list.get(i).getId() + "\t");
						System.out.println("이름 : " + list.get(i).getName());
						
					}
					break;


					case 2 : //추가
					MemberVO vo = new MemberVO(); //객체 생성
					
					System.out.println("회원 등록을 시작합니다.");
					
					System.out.println("회원 번호 : ");
					vo.setMemberno(sc.nextInt());
					
					System.out.println("회원 아이디 : ");
					vo.setId(sc.next());
					
					System.out.println("회원 이름 : ");
					vo.setName(sc.next());
					
					dao.insert(vo);
					break;

					
			}
		}

	}

}