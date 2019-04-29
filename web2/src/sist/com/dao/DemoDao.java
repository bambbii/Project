package sist.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sist.com.model.EmpBean;
import sist.service.util.ServiceUtil;

public class DemoDao {
	
	public static EmpBean selectEmpInfo(int empno) {
		Connection con=ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT EMPNO,ENAME,JOB,MGR,TO_CHAR(HIREDATE,'YYYY/MM/DD')HIREDATE,SAL,NVL(COMM,0)COMM,DEPTNO FROM EMP WHERE EMPNO=?";
		
		EmpBean emp=new EmpBean();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,empno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return emp;
	}
	
	public static List<EmpBean>selectEmp(){
		Connection con=ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		ArrayList<EmpBean>list=new ArrayList<EmpBean>();
		String sql="SELECT EMPNO,ENAME,JOB,MGR,TO_CHAR(HIREDATE,'YYYY/MM/DD')HIREDATE,SAL,NVL(COMM,0)COMM,DEPTNO FROM EMP";		
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				EmpBean emp=new EmpBean();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				list.add(emp);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
}
