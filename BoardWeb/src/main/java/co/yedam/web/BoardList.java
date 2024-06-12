package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.PageDTO;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

/*
 oracle db에 글목록을 조회 -> boardList.jsp 출력
 */

public class BoardList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = req.getParameter("page");
		page = page == null ? "1" : page; //페이지에 파라미터가 넘어오지않아도 1페이지를 보여주기위함
		
		BoardService svc = new BoardServiceImpl();
		//List<BoardVO> list = svc.boardList();
		List<BoardVO> list = svc.boardList(Integer.parseInt(page));
		
		
		req.setAttribute("boardList", list);
		
		
		
		//paging 계산
		int totalCnt = svc.boardTotal(); //1page ~ 25page
		PageDTO dto = new PageDTO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", dto);
		
		
		req.getRequestDispatcher("WEB-INF/view/boardList.jsp").forward(req, resp);

	}

}
