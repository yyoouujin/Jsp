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

public class addForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 게시판등록

		//req.getRequestDispatcher("WEB-INF/view/boardForm.jsp").forward(req, resp);
		req.getRequestDispatcher("board/boardForm.tiles").forward(req, resp);
		
		
	}

}
