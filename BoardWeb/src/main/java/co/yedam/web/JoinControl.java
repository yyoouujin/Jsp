package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.MemberMapper;
import co.yedam.service.MemberService;
import co.yedam.service.MemberServiceImpl;
import co.yedam.vo.MemberVO;

public class JoinControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// name=채유진&id=yujinjann&pw=solgkgk9715
		
		//서버에서 처리할때 받아오는이름이니까 지정
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		MemberService svc = new MemberServiceImpl();
		
		MemberVO mem = new MemberVO();
		mem.setUserId(id);
		mem.setUserName(name);
		mem.setUserPw(pw);
		
		
		if(svc.addMember(mem)) {
			System.out.println("회원가입이 완료되었습니다");
			resp.sendRedirect("loginForm.do");
		} else {
			System.out.println("회원가입실패");
			req.getRequestDispatcher("member/joinForm.tiles").forward(req, resp);
		}
	

	}

}
