package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class ModifyBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//http://localhost/BoardWeb/modifyBoard.do?bno=content=
		String boardno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
				
		// editBoard메소드의 매개값.
		BoardVO bvo = new BoardVO();
		bvo.setBoardNo(Integer.parseInt(boardno));
		bvo.setTitle(title);
		bvo.setContent(content);
		
		
		BoardService bvc = new BoardServiceImpl();
		if(bvc.editBoard(bvo)) {
			System.out.println("정상수정");
			resp.sendRedirect("boardList.do");
		} else {
			System.out.println("수정실패");
			req.getRequestDispatcher("WEB-INF/view/modifyBoardForm.jsp").forward(req, resp);
		}
		

	}

}
