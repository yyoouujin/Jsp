package co.yedam.vo;

import java.util.Date;

import lombok.Data; //getter&setter 등 많은 기능들을 알아서 구현해줌

/*
 테이블에있는 칼럼의 값들을 전달하는 클래스
*/

@Data
public class BoardVO { //ValueObject
	
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int clickCnt;
	private Date creationDate;
	

	
}
