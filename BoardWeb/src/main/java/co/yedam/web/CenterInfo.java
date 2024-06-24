package co.yedam.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.CenterVO;
import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class CenterInfo implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO JSON문자열 -> 객체 -> db insert
		
		
		ServletInputStream sis = req.getInputStream(); //stream : 자바에서 데이터를 주고받고할때 쓰여짐(통로)
		//두번째 매개값으로 인코딩방식 지정가능
		String json = StreamUtils.copyToString(sis, StandardCharsets.UTF_8); 
		System.out.println(json);
		
		//문자열 -> 객체
		ObjectMapper objectMapper = new ObjectMapper();
		CenterVO[] centers = objectMapper.readValue(json, CenterVO[].class); //CenterVO[] -> 센터를 여러건 담고 있는 배열
		
		ReplyService svc = new ReplyServiceImpl();
		int r = svc.createCenterInfo(centers);
		//{"txnCnt":3}
		resp.getWriter().print("{\"txnCnt\":" + r + "}");
		
	}

}
