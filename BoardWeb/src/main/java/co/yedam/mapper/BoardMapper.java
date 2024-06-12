package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.BoardVO;

/*
목록, 등록, 수정, 삭제, 단건조회의 기능 구성
*/

public interface BoardMapper {
	
	//목록
	List<BoardVO> boardList();
	List<BoardVO> boardListPaging(int page); //페이지별로 5건씩 출력
	int getTotalCnt(); //페이징 계산용도
	
	
	
	//등록
	int insertBoard(BoardVO bvo);
	
	
	//수정
	int updateBoard(BoardVO bvo);
	
	
	//삭제
	int deleteBoard(int bno);
	
	
	
	//단건조회
	BoardVO selectBoard(int bno);
	
	

}
