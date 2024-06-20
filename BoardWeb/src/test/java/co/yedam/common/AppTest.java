package co.yedam.common;

import java.util.function.Consumer;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		
		//interface - 구현객체.
//		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		mapper.deleteReply(5);
		//mapper.selectList(5).forEach(reply-> System.out.println(reply));
		
		
		//interface 에 구현할 메소드가 하나만 있는 인터페이스 : functional 인터페이스 (함수형 인터페이스)
		//컨슈머 인터페이스 : 구현하면서 메소드를 함께 바로 써줘야함
		//mapper.selectList(194).forEach(reply-> System.out.println(reply));  //람다표현식
		//ReplyVO rvo = mapper.selectReply(2);
		//System.out.println(rvo);
		
		/*
		ReplyVO rvo = new ReplyVO();
		rvo.setReply("댓글작성테스트2");
		rvo.setReplyer("무야호");
		rvo.setBoardNo(201);
		
		
		try {
			if(mapper.insertReply(rvo)==1) {
				System.out.println("입력성공");
			} 

		} catch (Exception e) {
			System.out.println("예외발생");
		}
		mapper.selectList(201).forEach(reply-> System.out.println(reply));
		*/
		
		
		
		/*
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		SearchVO search = new SearchVO(1, "T", "javascript");
		
		mapper.boardListPaging(search)//
			.forEach(bvo -> System.out.println(bvo));
		*/

		
		
		
	
	
//		List<BoardVO> list = mapper.boardListPaging(3);
//		for(BoardVO bvo : list) {
//			System.out.println(bvo.toString());
//			
//		}
//		
//		
//		BoardService svc = new BoardServiceImpl();
//		
//		System.out.println(svc.getBoard(100));
//				
		
		
		
		
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
//		
//		
//		
//		List<BoardVO> list = mapper.boardList();
//		for(BoardVO bvo : list) {
//			System.out.println(bvo.toString());
//			
//		}
		
		

		
		
		
//		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
//		Student std = new Student();
//		std.setStdNo("S0006");
//		std.setStdName("강동우");
//		std.setPhone("010-2222-6776");
//		std.setBldType("B");
//		
//		
//		
////		sqlSession.update("co.yedam.mapper.StudentMapper.updateStudent", std);
//		mapper.updateStudent(std);
//		mapper.deleteStudent(std);
//		sqlSession.commit();
//		
//		
////		sqlSession.insert("co.yedam.mapper.StudentMapper.insertStudent", std);
////		sqlSession.commit();
//		
//
//		
//		List<Student> list //
////		= sqlSession.selectList("co.yedam.mapper.StudentMapper.selectBlog");
//		= mapper.selectBlog();
//		
//		for (Student std1 : list) {
//			System.out.println(std1.toString());
//		}
		
	}
	
}
