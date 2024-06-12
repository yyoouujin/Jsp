package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.BoardMapper;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class removeBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String boardno = req.getParameter("bno");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		BoardService bvc = new BoardServiceImpl();
		
		BoardVO board = new BoardVO();
		board.setBoardNo(Integer.parseInt(boardno));

		
		if(bvc.removeBoard(Integer.parseInt(boardno))) {
			System.out.println("정상삭제");
			resp.sendRedirect("boardList.do");
		} else {
			System.out.println("삭제실패");
			req.getRequestDispatcher("WEB-INF/view/removeBoardForm.jsp").forward(req, resp);
			
		}
		

	}

}
