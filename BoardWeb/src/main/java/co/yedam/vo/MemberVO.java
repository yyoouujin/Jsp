package co.yedam.vo;

import lombok.Data;

@Data
public class MemberVO {
	
	private String userId;
	private String userPw;
	private String userName;
	
	//파일전송
	private String image;

}
