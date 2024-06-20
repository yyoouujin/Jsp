package co.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;
import co.yedam.vo.ReplyVO;

public class RemoveReply implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		// 댓글번호 -> 댓글삭제. 반환 : {"retCode":"OK"}
		int delRepNo = Integer.parseInt(req.getParameter("replyNo"));
		
		
		ReplyVO rvo = new ReplyVO();
		rvo.setReplyNo(delRepNo);
		
		ReplyService rvc = new ReplyServiceImpl();
		
		
		
		if(rvc.removeReply(delRepNo)) { //{"retCode":"OK"}
			
			resp.getWriter().print("{\"retCode\":\"OK\"}");
			
		} else { //{"retCode":"Fail"}
			
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}
		*/
		
		
		
		//[교수님이랑 같이]
		resp.setContentType("text/json;charset=utf-8");
		
		String rno = req.getParameter("rno");
		
		ReplyService svc = new ReplyServiceImpl();
		
		Map<String, Object> map = new HashMap<>(); //Map 이라는 인터페이스 내에 소속된 HashMap 이라는 구현 클래스
		Gson gson = new GsonBuilder().create();
		
		if(svc.removeReply(Integer.parseInt(rno))) {
			map.put("retCode", "OK");
			map.put("retMsg", "성공적으로 삭제되었습니다");
		} else {
			
			map.put("retCode", "NG");
			map.put("retMsg", "처리중 예외가 발생했습니다.");
			
		}
		String json = gson.toJson(map);
		resp.getWriter().print(json);

	}

	
	
}
