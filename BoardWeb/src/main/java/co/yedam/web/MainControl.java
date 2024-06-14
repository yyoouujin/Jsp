package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp)//
	throws ServletException, IOException {
		System.out.println("요청정보 : " + req + ", 응답정보 : " + resp);
		//WEB-INF/public/main.jsp
		//main.do 호출 -> main.jsp 페이지재지정.
		Student student = new Student();
		student.setStdNo("S0020");
		student.setStdName("이몽룡");
		student.setPhone("010-7777-9999");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		//매퍼의 기능을 따로 service로직 으로 생성시켜줌!
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> list = mapper.selectBlog();
		
		req.setAttribute("student", student);
		req.setAttribute("studentList", list);
		
		//req.getRequestDispatcher("WEB-INF/Public/main.jsp")
		req.getRequestDispatcher("member/main.tiles")//
		.forward(req, resp); //(HttpServletRequest에서 제공되는)forward 메소드 -> 요청 내용을 다른 자원으로 넘긴다
	
	}

}
