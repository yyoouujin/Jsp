package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	//PreparedStatement 클래스의 특징
	// 1. 인자 값으로 전달이 가능하다, 2. sql 문에 변수나 값을 넣을때 ?를 사용한다.
	
	
	public void getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String passwd = "jsp";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager .getConnection(url, user, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//Listener 연결을 끊어줘야함!
	
	public void disconn() {
			try {
				if(rs != null) {
				rs.close();
			}
				if(psmt != null) {
					psmt.close();
				}
				if (conn!= null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
	
	

} //end class *****
