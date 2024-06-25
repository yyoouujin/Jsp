package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.MemberMapper;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class JoinControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// name=채유진&id=yujinjann&pw=solgkgk9715
		
		//서버에서 처리할때 받아오는이름이니까 지정
		//파일첨부일 경우에는 multipart 요청을 처리 (1.요청정보 2.저장위치 3.최대크기 4.인코딩 5.리네임정책)
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;
		String encoding = "utf-8";
		
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
		
		
		String name = mr.getParameter("name");
		String id = mr.getParameter("id");
		String pw = mr.getParameter("pw");
		String img = mr.getFilesystemName("myImage");
		
		
		/*
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		*/

		//MemberService svc = new MemberServiceImpl();
		
		MemberVO mem = new MemberVO();
		mem.setUserId(id);
		mem.setUserName(name);
		mem.setUserPw(pw);
		mem.setImage(img);
		
		
		BoardService bvc = new BoardServiceImpl();
		
		try {
			
			if(bvc.addMemberImage(mem)) {
				if(req.getMethod().equals("POST")) {
					resp.sendRedirect("memberList.do");
				} else if (req.getMethod().equals("PUT")) {
					//{"retCode": "OK"}
					resp.getWriter().print("{\"retCode\": \"OK\"}");
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			if (req.getMethod().equals("PUT")) {
			//{"retCode": "NG"}
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}
		
		}	
		
		/*
		if(svc.addMember(mem)) {
			System.out.println("회원가입이 완료되었습니다");
			resp.sendRedirect("loginForm.do");
		} else {
			System.out.println("회원가입실패");
			req.getRequestDispatcher("member/joinForm.tiles").forward(req, resp);
		}
		*/
		
	

	}
	

}
