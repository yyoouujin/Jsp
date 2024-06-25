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
import co.yedam.web.AddMember;
import co.yedam.web.AddMemberForm;
import co.yedam.web.AddReply;
import co.yedam.web.AddStudent;
import co.yedam.web.AjaxForm;
import co.yedam.web.BoardList;
import co.yedam.web.CenterChart;
import co.yedam.web.CenterInfo;
import co.yedam.web.ChartForm;
import co.yedam.web.CheckIdAjax;
import co.yedam.web.GetBoard;
import co.yedam.web.JoinControl;
import co.yedam.web.JoinForm;
import co.yedam.web.LoginControl;
import co.yedam.web.LoginForm;
import co.yedam.web.LogoutControl;
import co.yedam.web.MainControl;
import co.yedam.web.MapForm;
import co.yedam.web.MemberAddAjax;
import co.yedam.web.MemberAjax;
import co.yedam.web.MemberList;
import co.yedam.web.ModifyAjax;
import co.yedam.web.ModifyBoard;
import co.yedam.web.ModifyForm;
import co.yedam.web.ProductControl;
import co.yedam.web.PublicData;
import co.yedam.web.RemoveIdAjax;
import co.yedam.web.RemoveReply;
import co.yedam.web.ReplyList;
import co.yedam.web.ScriptForm;
import co.yedam.web.StudentForm;
import co.yedam.web.TotalCnt;
import co.yedam.web.addForm;
import co.yedam.web.removeBoard;
import co.yedam.web.removeForm;

//front -> 요청url(*.do) - 실행컨트롤 매칭.
//모든 작업이 거쳐가는곳 = frontcontroll
public class FrontController extends HttpServlet {
	// main.do -> FrontController -> /WEB-INF/public/main.jsp
	// 객체생성 -> init -> service -> destroy

	private Map<String, Control> map; // key : url, value : controll

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		map.put("/main.do", new MainControl()); // "/main.do" -> 키 역할 / MainControl객체반환
		map.put("/product.do", new ProductControl());
		// map.put("/board.do", "게시판페이지입니다.");

		map.put("/studentForm.do", new StudentForm()); // 등록화면(입력값을 받음)
		map.put("/addStudent.do", new AddStudent()); // 정보db에 저장

		// 게시글목록.
		map.put("/boardList.do", new BoardList());

		// 상세화면
		map.put("/getBoard.do", new GetBoard());

		// 게시글등록.
		map.put("/addForm.do", new addForm());
		map.put("/addBoard.do", new AddBoard());

		// 게시글삭제
		map.put("/removeForm.do", new removeForm()); // 삭제화면구현
		map.put("/removeBoard.do", new removeBoard()); // 삭제기능구현

		// 수정화면
		map.put("/modifyForm.do", new ModifyForm()); // 수정화면구현
		// 수정처리
		map.put("/modifyBoard.do", new ModifyBoard()); // 수정기능구현

		// 로그인화면
		map.put("/loginForm.do", new LoginForm());
		// 로그인기능
		map.put("/Login.do", new LoginControl());
		// 로그아웃기능
		map.put("/Logout.do", new LogoutControl());
		
		//회원가입 화면(채유진)
		map.put("/joinForm.do", new JoinForm());
		//회원가입 기능(채유진)
		map.put("/join.do", new JoinControl());
		
		
		//회원가입 화면(교수님공유)
		map.put("/addMemberForm.do", new AddMemberForm());
		map.put("/addMember.do", new AddMember());
		
		
		//회원목록(관리자템플릿)
		map.put("/memberList.do", new MemberList());
		
		
		
		//자바스크립트 연습용 페이지
		map.put("/script.do", new ScriptForm());
		
		
		
		//아작스 연습
		map.put("/ajax.do", new AjaxForm());
		//JSON문자열을 반환하는 컨트롤러
		map.put("/memberAjax.do", new MemberAjax());
		//데이터 등록 (ajax)
		map.put("/addAjax.do", new MemberAddAjax());
		//id체크
		map.put("/checkIdAjax.do", new CheckIdAjax());
		//삭제
		map.put("/removeIdAjax.do", new RemoveIdAjax());
		//수정
		map.put("/modifyAjax.do", new ModifyAjax());
		
		
		//댓글관련 (maven - gson pom.xml에디펜던시 추가 : 구글 라이브러리)
		//댓글목록
		map.put("/replyListJson.do", new ReplyList());
		//댓글삭제
		map.put("/removeReply.do", new RemoveReply());
		//댓글등록
		map.put("/addReply.do", new AddReply());
		
		//댓글전체건수
		map.put("/replyTotalCnt.do", new TotalCnt());
		
		
		
		//공공데이터포털
		map.put("/publicData.do", new PublicData());
		
		
		//map api 호출
		map.put("/map.do", new MapForm());
		
		//JSON 문자열 -> db insert
		map.put("/centerInfo.do", new CenterInfo());
		
		//센터차트
		map.put("/chartForm.do", new ChartForm());
		map.put("/centerChart.do", new CenterChart());

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // http://localhost/BoardWeb/main.do
//		System.out.println("uri : " + uri); //BoardWeb/main.do
		String context = req.getContextPath(); // BoardWeb => projectname
//		System.out.println("context : " + context);
		String page = uri.substring(context.length()); // 어떤 페이지를 요청하고있는지
//		System.out.println("page : " + page);
		// String result = map.get(page);
		// System.out.println("result : " + result);
		Control result = map.get(page); // MainControl을 구현하는 객체를 result 에 담아서 반환!
		result.exec(req, resp);

		/*
		 * 1. 프로젝트 실행 -> 톰캣이 web.xml 파일을 제일 먼저 읽어줌 2. <welcome-file-list> 3.
		 * <servlet-mapping> 4. <servlet>
		 */

	}

}