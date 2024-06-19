package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO2;

public class RemoveIdAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		
		MemberVO2 mvo = new MemberVO2();
		mvo.setUserId(id);
		
		BoardService svc = new BoardServiceImpl();
		if(svc.deleteMemberId(id)) { // {"retCode":"Remove Success"}
			
			resp.getWriter().print("{\"retCode\":\"Remove Success\"}");
			
		} else { //// {"retCode":"Remove Fail"}
			
			resp.getWriter().print("{\"retCode\":\"Remove Fail\"}");
		}

	}

}
