package co.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.yedam.common.CenterVO;
import co.yedam.vo.ReplyVO;

public interface ReplyMapper {
	//목록, 단건조회, 등록, 삭제
	List<ReplyVO> selectList(int boardNo);
	ReplyVO selectReply(int replyNo);
	int insertReply(ReplyVO rvo);
	int deleteReply(int replyNo);
	
	//페이지별로 댓글출력
		//@Param -> mybatis의 기능, 파라미터의 이름을 정해줄 수 있다(xml파일에서 사용하는 변수이름과 이름을 맞춰줘야한다!)
	List<ReplyVO> selectListPaging(@Param("boardNo") int boardNo, @Param("page") int page);
	
	//댓글건수.
	int selectReplyCnt(int bno);
	
	//센터정보 생성
	int insertCenter(CenterVO[] array);
	
	//시도별 센터갯수 차트
	List<Map<String, Object>> centerBysido();

}
