package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class ModifyForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// bno 파라미터의 값을 읽어서 출력
		String bno = req.getParameter("bno");
		// 글번호 bno 정보를 조회.
		
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.getBoard(Integer.parseInt(bno));
		
		
		//요청정보의 attribute(=board)
		//setAttribute("board", board) = 이름이 "board"인 속성 값을 board로 지정한다
		req.setAttribute("board", board);
		
		
		req.getRequestDispatcher("WEB-INF/view/modifyBoardForm.jsp").forward(req, resp);
		
		

	}

}
