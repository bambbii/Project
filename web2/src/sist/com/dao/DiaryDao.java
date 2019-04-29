package sist.com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import sist.com.model.DiaryBean;
import sist.com.model.DiaryBeanInput;
import sist.com.model.DiaryMember;

public class DiaryDao {
	private static SqlSessionFactory sessionFactory;
	
	static {
		sessionFactory=SqlSessionFactoryManager.getSqlSessionFactory();
	}
	
	public static void joinMember(DiaryMember bean) {
		SqlSession session=null;
		try {
			session=sessionFactory.openSession();
			session.insert("joinMember", bean);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
		
	}
	
	public static String idCheck(String id) {
		SqlSession session=null;
		try {
			session=sessionFactory.openSession();
			return session.selectOne("idCheck", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}return null;
	}
	
	public static DiaryMember passCheck(String id) {
		SqlSession session=null;
		try {
			session=sessionFactory.openSession();
			return session.selectOne("passCheck", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}return null;
	}
	
	public static void insertData(DiaryBean bean) {
		SqlSession session=null;
		try {
			session=sessionFactory.openSession();
			session.insert("insertData",bean);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	public static List<DiaryBean> selectListDiary(int no) {
		SqlSession session=null;
		try {
			session=sessionFactory.openSession();
			return session.selectList("selectListDiary",no);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}return null;
	}
	
	public static DiaryBean selectListDiaryInfo(int no) {
		SqlSession session=null;
		try {
			session=sessionFactory.openSession();
			return session.selectOne("selectListDiaryInfo",no);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}return null;
		
	}
	
	public static void deleteDiaryInfo(int no) {
		SqlSession session=null;
		try {
			session=sessionFactory.openSession();
			session.delete("deleteDiaryInfo",no);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
		
	}
	
	public static void updateData(DiaryBean bean) {
		SqlSession session=null;
		try {
			session=sessionFactory.openSession();
			session.update("updateData",bean);
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