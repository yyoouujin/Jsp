package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.BoardVO;

/*
목록, 등록, 수정, 삭제, 단건조회의 기능 구성
*/

public interface BoardMapper {
	
	//목록
	List<BoardVO> boardList();
	
	
	//등록
	int insertBoard(BoardVO bvo);
	
	
	//수정
	int updateBoard(BoardVO bvo);
	
	
	//삭제
	int deleteBoard(int bno);
	
	
	//단건조회
	BoardVO selectBoard(int bno);
	
	

}
