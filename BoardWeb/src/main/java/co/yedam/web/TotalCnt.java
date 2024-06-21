package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class TotalCnt implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO bno => 댓글건수.
		String bno = req.getParameter("bno");
		
		ReplyService svc = new ReplyServiceImpl();
		int totalCnt = svc.getTotalCount(Integer.parseInt(bno)); //board_no에 달린 총 댓글갯수
		
		resp.getWriter().print(totalCnt);
		
		

	}

}
