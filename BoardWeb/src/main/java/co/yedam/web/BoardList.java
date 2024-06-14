package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.PageDTO;
import co.yedam.common.SearchVO;
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
		
		//boardList.do?searchCondition=W&keyword=ddd
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		page = page == null ? "1" : page; //페이지에 파라미터가 넘어오지않아도 1페이지를 보여주기위함
		//검색조건들을 담는 SearchVO
		SearchVO search = new SearchVO(Integer.parseInt(page), sc, kw);
		
		
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(search);
		//List<BoardVO> list = svc.boardList(Integer.parseInt(page));
		
		
		req.setAttribute("boardList", list);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		
		//paging 계산
		
		//int totalCnt = svc.boardTotal(); //1page ~ 25page
		int totalCnt = svc.boardTotal(search);
		PageDTO dto = new PageDTO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", dto);
		
		
		//req.getRequestDispatcher("WEB-INF/view/boardList.jsp").forward(req, resp);
		req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);

	}

}
