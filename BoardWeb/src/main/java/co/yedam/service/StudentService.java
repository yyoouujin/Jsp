package co.yedam.service;

import java.util.List;

import co.yedam.vo.Student;

public interface StudentService {
	//목록
	List<Student> studentList();
	//등록
	boolean addStudent(Student std);
	//수정
	boolean modifyStudent(Student std);
	
}
