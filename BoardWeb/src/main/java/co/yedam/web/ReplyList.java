package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;
import co.yedam.vo.ReplyVO;

public class ReplyList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 몇번글에 대한 목록?
		resp.setContentType("text/json;charset=utf-8"); //한글처리
		String bno = req.getParameter("bno");
		
		//댓글목록
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(Integer.parseInt(bno));
		
		//gson 객체추가 (Gson 디펜던시 추가) : JSON문자열을 반환해준다
		//Gson gson = new GsonBuilder().create(); //gson객체생성
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); //gson문자열을 정렬해줌
		String json = gson.toJson(list); //객체 -> 문자열
		
		resp.getWriter().print(json); //출력

	}

}
