package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Login.do?id=&pw=
		
		//req = HttpServletRequest : 클라이언트가 서버에 보내는 요청정보 처리 ("id")
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		
		BoardService svc = new BoardServiceImpl();
		
		
		//if(id.equals("user01") && pw.equals("9715")) {
		if(svc.checkMember(id, pw)) {
				//로그인.
			//세션객체생성
			HttpSession session = req.getSession();
			//setAttribute 메소드는 이름, 값 쌍으로 세션에 정보를 저장할 수 있습니다
			session.setAttribute("loginId", id);
			
			
			//resp = HttpServletResponse : 서비스를 요청한 클라이언트에게 응답해준다 ("main.do" 로 가라)
			resp.sendRedirect("main.do");
			
		} else {
			resp.sendRedirect("loginForm.do");
		}
		

	}

}
