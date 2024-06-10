package co.yedam;

import java.util.Date;

public class Student {
	//필드
	private String stdNo;
	private String stdName;
	private String phone;
	private String bldType;
	private Date createDate;
	public String getStdNo() {
		return stdNo;
	}
	
	
	//생성자
	
	//메소드 getter&setter
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBldType() {
		return bldType;
	}
	public void setBldType(String bldType) {
		this.bldType = bldType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}




	
	//toString 오버라이드(Source -> Generate toString 으로도 가능)
	@Override
	public String toString() {
		return "Student [stdNo=" + stdNo + ", stdName=" + stdName + ", phone=" + phone + ", bldType=" + bldType
				+ ", createDate=" + createDate + "]";
	}
	
	

} //end class *****
