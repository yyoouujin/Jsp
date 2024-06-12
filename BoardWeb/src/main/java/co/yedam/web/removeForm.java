package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class removeForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터정보를 읽어서 게시글번호 조회
		//removeBoardForm.jsp 페이지에 출력
		
		
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		BoardService bvc = new BoardServiceImpl();
		BoardVO brd = bvc.getBoard(Integer.parseInt(bno));
		
		req.setAttribute("board", brd);
		req.setAttribute("page", page);
		
		
		req.getRequestDispatcher("WEB-INF/view/removeBoardForm.jsp").forward(req, resp);
		

	}

}
