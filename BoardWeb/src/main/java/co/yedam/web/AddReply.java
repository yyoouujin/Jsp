package co.yedam.web;

import java.io.IOException;
import java.util.Date;
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

public class AddReply implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//post방법으로 요청 시 한글 포함문자는 따로 변경해줘야한다
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		
		String bno = req.getParameter("bno");
		String replyer = req.getParameter("replyer");
		String reply = req.getParameter("reply");

		
		ReplyVO rvo = new ReplyVO();
		
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReplyer(replyer);
		rvo.setReply(reply);
		System.out.println(rvo);
		
		
		Map<String, Object> map = new HashMap<>();
		
		Gson gson = new GsonBuilder().create();
		
		ReplyService rsv = new ReplyServiceImpl();
		
		
		try {
			if(rsv.registerReply(rvo)) {
				//성공 or 실패로 넘겨주기 위함, else는 그닥,,
				//try catch로 예외처리를 하는게맞음
				rvo.setReplyDate(new Date());
				System.out.println(rvo);
				map.put("retCode", "OK");
				map.put("retVal", rvo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("retCode", "NG");
			map.put("retVal", "처리중 오류가 발생했습니다");
		}
		//웹브라우저에 출력하기 위함
		resp.getWriter().print(gson.toJson(map));
		
	}

}
