package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //자동커밋 : openSession(true)
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

	@Override
	public List<ReplyVO> replyList(int boardNo) {
		return mapper.selectList(boardNo);
	}

	@Override
	public ReplyVO getReply(int replyNo) {
		return mapper.selectReply(replyNo);
	}

	@Override
	public boolean registerReply(ReplyVO rvo) {
		return mapper.insertReply(rvo)==1;
		
	}

	@Override
	public boolean removeReply(int replyNo) {
		return mapper.deleteReply(replyNo)==1;
	}


}