package co.yedam;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	/*
	 제어의 역전(IOC : Inversion of Control)
	 
	[서블릿의 실행순서 = 서블릿의 생명주기]
	url호출 -> tomcat (서블릿 컨테이너) -> 객체생성 -> init()메소드 호출 -> service() -> destory.
	*/
public class SecondServlet extends HttpServlet {
	
	
	public SecondServlet() {
		System.out.println("SecondServlet 생성자 호출.");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 메소드 호출");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}
	
	
}
