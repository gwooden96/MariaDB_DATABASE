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
			System.out.print("메뉴선택[1.전체회원목록보기 2.회원정보추가 3.회원정보수정 4.회원정보삭제 5.회원정보찾기]");
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



					case 3 : //수정
					vo = new MemberVO();
					
					System.out.println("회원 정보를 수정합니다.");
					
					System.out.println("회원 번호 수정 : ");
					vo.setMemberno(sc.nextInt());
					
					System.out.println("회원 아이디 수정 : ");
					vo.setId(sc.next());
					
					System.out.println("회원 이름 수정 : ");
					vo.setName(sc.next());
					
					dao.update(vo);
					break;


					case 4 : //삭제
					MemberVO vod = new MemberVO();
					
					System.out.println("회원 정보를 삭제합니다.");
					
					System.out.println("삭제할 회원 번호 : ");
					vod.setMemberno(sc.nextInt());
					
					dao.delete(vod);
					break;

					case 5 : //조회
					
					
					System.out.println("회원 정보를 조회합니다.");
					
					System.out.println("조회할 회원 번호 : ");
					List<MemberVO> sList = dao.select(sc.nextInt());
					
					for(int i = 0; i < sList.size(); i++) {
						
						System.out.print("번호 : " + sList.get(i).getMemberno() + "\t");
						System.out.print("아이디 : " + sList.get(i).getId() + "\t");
						System.out.println("이름 : " + sList.get(i).getName());
						
					}
					break;


					default :    
					System.out.println("잘 못 입력하셨습니다.");


			}
		}

	}

}