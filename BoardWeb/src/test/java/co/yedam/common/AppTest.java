package co.yedam.common;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		
		List<Map<String, Object>> result = mapper.centerBysido();
		
		for(Map<String, Object> map : result) {
			Set<String> keyset = map.keySet();
			for(String key:keyset) {
				System.out.println("key:" + key + ", val:" + map.get(key));
				//System.out.println(map.get("sido") + ", " + map.get("cnt"));
				System.out.println("----------------------");
			}
		}
		

		
		
		/*
		CenterVO cvo1 = new CenterVO();
		cvo1.setAddress("ad1");
		cvo1.setId("1");
		cvo1.setCenterName("cn1");
		cvo1.setSido("sd1");
		cvo1.setPhoneNumber("ph1");
		CenterVO cvo2 = new CenterVO();
		cvo2.setAddress("ad2");
		cvo2.setId("2");
		cvo2.setCenterName("cn2");
		cvo2.setSido("sd2");
		cvo2.setPhoneNumber("ph2");
		
		CenterVO[] centers = {cvo1, cvo2};
		int r = mapper.insertCenter(centers);
		System.out.println(r + "건 입력.");
		*/
		
		
		//mapper.selectListPaging(227,6).forEach(reply-> System.out.println(reply));

		
		//interface - 구현객체.
//		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		
		//ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		//mapper.deleteReply(5);
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
