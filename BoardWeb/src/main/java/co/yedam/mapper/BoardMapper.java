package co.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;
import co.yedam.vo.MemberVO2;

/*
목록, 등록, 수정, 삭제, 단건조회의 기능 구성
*/

public interface BoardMapper {

	// 목록
	List<BoardVO> boardList();

	//List<BoardVO> boardListPaging(int page); // 페이지별로 5건씩 출력
	List<BoardVO> boardListPaging(SearchVO search); // 페이지별로 5건씩 출력

	int getTotalCnt(SearchVO search); // 페이징 계산용도

	// 등록
	int insertBoard(BoardVO bvo);

	// 수정
	int updateBoard(BoardVO bvo);

	// 삭제
	int deleteBoard(int bno);

	// 단건조회
	BoardVO selectBoard(int bno);

	// 회원id, 회원비번
	// @Param -> mapper 내에 값을 전달
	//@Param 은 database 프로그램 (oracle)의 sql 문장에 파라미터를 전달할 때 전달되는 변수들에 붙여준다
	//mapper 인터페이스에서 전달하고자 하는 변수명 앞에 @Param 어노테이션을 추가
	MemberVO2 selectMember(@Param("id") String id, @Param("pw") String pw);
	
	
	
	//서버에 있는 데이터를 끌고오기위함(ajax연습)
	List<MemberVO2> memberList();
	
	int insertMemberAjax(MemberVO2 mvo);
	
	int selectMemberAjax(String id);
	
	int deleteMemberAjax(String id);
	
	//수정
	int updateMemberAjax(MemberVO2 mvo);
	
	
	//파일전송
	int insertMember(MemberVO mvo);
	
	
	

}
