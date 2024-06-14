package co.yedam.service;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;

/*
목록, 단건조회, 등록, 수정, 삭제기능 (규칙정의)
기능의 실행은 mapper에있는것으로 실행
*/

public interface BoardService {

	//목록
	//List<BoardVO> boardList();
	//List<BoardVO> boardList(int page);
	List<BoardVO> boardList(SearchVO search);
	
	int boardTotal(SearchVO search);
	
	//단건조회
	BoardVO getBoard(int bno);
	
	//등록
	boolean addBoard(BoardVO bvo);

	//수정
	boolean editBoard(BoardVO bvo);
	
	//삭제
	boolean removeBoard(int bno);
	
	
	
	//checkMember(id,pw)
	boolean checkMember(String id, String pw);

}
