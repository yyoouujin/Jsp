package co.yedam.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;
import co.yedam.vo.MemberVO2;

public class AddMember implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//파일첨부일 경우에는 multipart 요청을 처리 (1.요청정보 2.저장위치 3.최대크기 4.인코딩 5.리네임정책)
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;
		String encoding = "utf-8";
		
		new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
		
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		
		MemberVO mvo = new MemberVO();
		MemberVO2 mvo2 = new MemberVO2();
		mvo2.setUserId(id);
		mvo2.setUserName(pw);
		mvo2.setUserPw(name);
		
		BoardService svc = new BoardServiceImpl();
		//Map<String, String> result = svc.addMemberAjax(mvo2);

		/*
		if (result.get("retCode").equals("OK")) {
			resp.sendRedirect("main.do");

		} else {
			req.setAttribute("message", result.get("message"));
			req.getRequestDispatcher("member/addMemberForm.tiles")//
					.forward(req, resp);
		}
		*/
		

	}
	
		

}
