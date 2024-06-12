package co.yedam.common;

import lombok.Data;

//Data To Object클래스

@Data
public class PageDTO {
	
	private int startPage, endPage; //첫페이지, 마지막페이지 계산용
	private boolean prev, next; //이전, 이후 페이지 계산용
	private int page; //현재페이지 기준
	
	
	//생성자
	public PageDTO(int page, int totalCnt) {
		this.page = page; //11page ~ 14page ~ 20page
		this.endPage = (int)Math.ceil(page/10.0) * 10; //현재 페이지 14 -> 20도출
		this.startPage = this.endPage - 9; // 현재 페이지 14 -> 마지막페이지 20 도출 - 9 = 11 -> 첫페이지 11 도출
		
		int realEnd = (int)Math.ceil(totalCnt/5.0);
		this.endPage = (this.endPage > realEnd) ? realEnd : this.endPage; //유효 마지막 페이지 설정
		
		this.prev = this.startPage > 1 ;
		this.next = (this.endPage == realEnd) ? false : true; //유효페이지만 출력 (> -> ==)
	}
	

	
	
}
