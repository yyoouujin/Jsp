package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.web.AddBoard;
import co.yedam.web.AddStudent;
import co.yedam.web.BoardList;
import co.yedam.web.GetBoard;
import co.yedam.web.MainControl;
import co.yedam.web.ProductControl;
import co.yedam.web.StudentForm;
import co.yedam.web.addForm;
//front -> 요청url(*.do) - 실행컨트롤 매칭.
//모든 작업이 거쳐가는곳 = frontcontroll
public class FrontController extends HttpServlet {
	//main.do -> FrontController -> /WEB-INF/public/main.jsp
	//객체생성 -> init -> service -> destroy
	
	private Map<String, Control> map; //key : url, value : controll
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl()); //"/main.do" -> 키 역할 / MainControl객체반환
		map.put("/product.do", new ProductControl());
		//map.put("/board.do", "게시판페이지입니다.");
		
		
		map.put("/studentForm.do", new StudentForm()); //등록화면(입력값을 받음)
		map.put("/addStudent.do", new AddStudent()); //정보db에 저장
		
		
		//게시글목록.
		map.put("/boardList.do", new BoardList());
		
		//상세화면
		map.put("/getBoard.do", new GetBoard());
		
		//게시글등록.
		map.put("/addForm.do", new addForm());
		map.put("/addBoard.do", new AddBoard());
		
		
	}
	
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); //http://localhost/BoardWeb/main.do
//		System.out.println("uri : " + uri); //BoardWeb/main.do
		String context = req.getContextPath(); //BoardWeb => projectname
//		System.out.println("context : " + context);
		String page = uri.substring(context.length()); //어떤 페이지를 요청하고있는지
//		System.out.println("page : " + page);
		
		//String result = map.get(page);
		//System.out.println("result : " + result);
		Control result = map.get(page); //MainControl을 구현하는 객체를 result 에 담아서 반환!
		result.exec(req, resp);
		
	/*
	1. 프로젝트 실행 -> 톰캣이 web.xml 파일을 제일 먼저 읽어줌
	2. <welcome-file-list>
	3. <servlet-mapping>
	4. <servlet>
	*/
		
	}
	
	
}