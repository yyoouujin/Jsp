package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;
import co.yedam.vo.MemberVO2;

/*
업무프로세스를 따라 실행하기 위한 서비스.
*/

public class BoardServiceImpl implements BoardService {
	
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //자동커밋 : openSession(true)
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	

	
	@Override
//	public List<BoardVO> boardList() {
//		//mapper등록된 기능 활용.
//		return mapper.boardList();
//	}
	
	//public List<BoardVO> boardList(int page)
	public List<BoardVO> boardList(SearchVO search){
		//mapper등록된 기능 활용.
		return mapper.boardListPaging(search);
	}
	
	@Override
	public int boardTotal(SearchVO search) {
		return mapper.getTotalCnt(search);
	}

	@Override
	public BoardVO getBoard(int bno) {
		return mapper.selectBoard(bno);
	}

	@Override
	public boolean addBoard(BoardVO bvo) {
		return mapper.insertBoard(bvo)==1;
		
	}

	@Override
	public boolean editBoard(BoardVO bvo) {
		return mapper.updateBoard(bvo)==1;
	}

	@Override
	public boolean removeBoard(int bno) {
		return mapper.deleteBoard(bno)==1;
	}
	
	
	@Override
	public MemberVO2 checkMember(String id, String pw) {
		return mapper.selectMember(id, pw);
	}
	
	
	
	@Override
	public List<MemberVO2> memberList() {
		return mapper.memberList();
	}
	
	
	@Override
	public boolean addMemberAjax(MemberVO2 mvo) {
		return mapper.insertMemberAjax(mvo)==1;
		
	}
	
	
	@Override
	public boolean checkMemberId(String id) {
		return mapper.selectMemberAjax(id)==1;
	}
	
	
	@Override
	public boolean deleteMemberId(String id) {
		return mapper.deleteMemberAjax(id)==1;
	}
	
	
	@Override
	public boolean modifyMember(MemberVO2 mvo) {
		return mapper.updateMemberAjax(mvo)==1;
	}
	
	
	@Override
	public boolean addMemberImage(MemberVO mvo) {
		return mapper.insertMember(mvo) == 1;
	}

	}

