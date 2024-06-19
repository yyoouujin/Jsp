package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO2;

public class MemberAddAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 4개를 받아와서 -> DB입력 -> OK반환.
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String nm = req.getParameter("nm");
		String auth = req.getParameter("auth");
		
		MemberVO2 mvo = new MemberVO2();
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setUserName(nm);
		mvo.setResponsibility(auth);
		
		BoardService svc = new BoardServiceImpl();
		if(svc.addMemberAjax(mvo)) { // {"retCode":"OK","retMsg":"Success"}
			resp.getWriter().print("{\"retCode\":\"OK\",\"retMsg\":\"Success\"}");
		} else { // {"retCode":"NG","retMsg":"Fail"}
			resp.getWriter().print("{\"retCode\":\"NG\",\"retMsg\":\"Fail\"}");
		}

	}

}



/*
 json += "{\"userId\":\""+list.get(i).getUserId()//
+"\",\"userPw\":\""+list.get(i).getUserPw()//
+"\",\"userName\":\""+list.get(i).getUserName()//
+"\",\"responsibility\":\""+list.get(i).getResponsibility()//
+"\"}";

*/

