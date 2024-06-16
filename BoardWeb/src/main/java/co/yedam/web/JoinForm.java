package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;

public class JoinForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//req.getRequestDispatcher("WEB-INF/view/joinForm.jsp").forward(req, resp);
		req.getRequestDispatcher("member/joinForm.tiles").forward(req, resp);
		

	}

}
