package co.yedam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO {
	//등록, 삭제, 수정, 목록 기능 구현
	
	

	
	
	//목록을 가져오는 기능
	List<Student> studentList() {
		getConnection(); //Connection객체(세션)을 받아와야 목록 출력이 가능하다! (DB에 접속하기 위함)
		String sql = "select * from tbl_student order by std_no";
		List<Student> students = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			// 조회된 결과목록을 List<Students>에 담아서 반환.
			while(rs.next()) {
				Student std = new Student();
				std.setStdNo(rs.getString("std_no"));
				std.setStdName(rs.getString("std_name"));
				std.setPhone(rs.getString("phone"));
				std.setBldType(rs.getString("bld_type"));
				std.setCreateDate(rs.getDate("create_date"));
				
				students.add(std); //데이터베이스의 조회값 하나를 List에 담아줌
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); //사용한 자원(resource)을 해제
		}
		return students;
	}
	
	
	
	

//	insert into tbl_student (std_no, std_name, phone, bld_type)
//	values('S0004', '김수연', '010-6576-5573', 'A');
	//등록
	boolean insertStudent(Student std) {
		getConnection();
		String sql = "insert into tbl_student(std_no, std_name, phone, bld_type) values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo());
			psmt.setString(2, std.getStdName());
			psmt.setString(3, std.getPhone());
			psmt.setString(4, std.getBldType());
			if(psmt.executeUpdate() == 1) { //처리된 건수 == 1
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); //사용한 자원(resource)을 해제
		}
		return false;
	} //end of insertStudent()
	
	
	
	
	
//	update tbl_student
//	set    phone = '010-2222-3333'
//	where std_no = 'S0003';
	//정보수정
	boolean updateStudent(Student std) {
		getConnection();
		String sql = "update tbl_student set phone = ? where std_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getPhone());
			psmt.setString(2, std.getStdNo());
			
			if(psmt.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn(); //사용한 자원(resource)을 해제
		}
		
		return false;
	}
	
	
	
	
	
//	delete from tbl_student
//	where std_no = 'S0003';
	//삭제
	boolean deleteStudent(String stdNo) {
		getConnection();
		String sql = "delete from tbl_student where std_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdNo);
			if(psmt.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn(); //사용한 자원(resource)을 해제
		}
		return false;
	}
	
	
	
	
	
} //end class *****
