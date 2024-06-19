package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO2;

public class ModifyAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nm = req.getParameter("nm");
		String pw = req.getParameter("pw");
		String id = req.getParameter("id");
		
		MemberVO2 mvo = new MemberVO2();
		mvo.setUserId(id);
		mvo.setUserName(nm);
		mvo.setUserPw(pw);
		
		BoardService svc = new BoardServiceImpl();
		
		if(svc.modifyMember(mvo)) { // {"retCode":"Success"}
			
			resp.getWriter().print("{\"retCode\":\"Success\"}");
			
		} else {  // {"retCode":"Fail"}
			
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
			
		}
		
		

	}

}
