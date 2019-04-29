package sist.com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import sist.com.vo.BoardVO;

public class BoardDao {
private static SqlSessionFactory sessionFactory;
	
	static {
		sessionFactory=SqlSessionFactoryManager.getSqlSessionFactory();
	}	
	public static List<BoardVO> selectBoard(HashMap<String, Object>map){
		SqlSession session=null;
		
		try {
			session=sessionFactory.openSession();

			return session.selectList("selectBoard",map);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		
		return null;
		
	}
	
	public static void insertBoard(BoardVO vo) {
		SqlSession session=null;
	    try {
	    	session=sessionFactory.openSession();
	    	session.insert("insertBoard", vo);
	    	session.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
		
	}
	
	public static void updateHit(int no) {
		SqlSession session=null;//오라클 서버를 접근할 수 있는 객체
		try {
			session=sessionFactory.openSession();
			session.update("updateHit", no);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	public static BoardVO selectInfoBoard(int no) {
		SqlSession session=null;
		try {
			session=sessionFactory.openSession();
			return session.selectOne("selectInfoBoard", no);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return null;
	}
	
	public static void deleteInfo(int no) {
		SqlSession session=null;
		try {
			session=sessionFactory.openSession();
			session.delete("deleteInfo",no);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	public static String dbPass(int no) {
		SqlSession session=null;
		String temp="";
		try {
			session=sessionFactory.openSession();
			temp=session.selectOne("dbPass",no);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return temp;
	}
	
	public static Integer getTotalRow(HashMap<String, Object>map) {
		SqlSession session=null;
		try {
			session=sessionFactory.openSession();
			return session.selectOne("getTotalRow",map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return 0;
	}//method
	
	public static String getFileName(int no) {
		SqlSession session=null;
		try {
			session=sessionFactory.openSession();
			return session.selectOne("getFileName",no);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}return null;
	}
	
	public static void updateBoard(BoardVO vo) {
		SqlSession session=null;
		try {
			session=sessionFactory.openSession();
			session.update("updateBoard", vo);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
}
