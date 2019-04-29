package sist.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sist.com.model.StudentBean;
import sist.service.util.ServiceUtil;

public class StudDao {
	
	public static List<StudentBean> selectList(){
		ArrayList<StudentBean>list=new ArrayList<StudentBean>();
		Connection con=ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT STUDNO,NAME,USERID,GRADE,IDNUM,BIRTHDATE,TEL,HEIGHT,WEIGHT,DEPTNO,PROFNO FROM STUDENT";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				StudentBean sb=new StudentBean();
				sb.setStudno(rs.getInt("studno"));
				sb.setName(rs.getString("name"));
				sb.setUserid(rs.getString("userid"));
				sb.setGrade(rs.getInt("grade"));
				sb.setIdnum(rs.getInt("idnum"));
				sb.setBirthdate(rs.getString("birthdate"));
				sb.setTel(rs.getString("tel"));
				sb.setHeight(rs.getInt("height"));
				sb.setWeight(rs.getInt("weight"));
				sb.setDeptno(rs.getInt("deptno"));
				sb.setProfno(rs.getInt("profno"));
				list.add(sb);
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
		return list;
	}
}
