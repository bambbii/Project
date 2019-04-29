package sist.com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sist.service.util.ServiceUtil;

public class LoginMemberDao {
	private Connection con=ServiceUtil.getConnection();
	private PreparedStatement pst;
	private static LoginMemberDao dao;
	
	public static LoginMemberDao getInstance() {
		if(dao==null) {
			dao=new LoginMemberDao();
		}
		return dao;
	}
	
	public List<LoginMember> selectMember(){
		ArrayList<LoginMember>list=new ArrayList<LoginMember>();
		String sql="SELECT * FROM LOGINTEST";
		ResultSet rs=null;
		try {
			pst=con.prepareStatement(sql);//운반객체를 생성
			rs=pst.executeQuery();
			while(rs.next()) {
				LoginMember m=new LoginMember();
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setAddr(rs.getString("addr"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public boolean loginMemberCheck(HashMap<String, String>map) {
		String sql="SELECT PASS FROM LOGINTEST WHERE ID=?";
		ResultSet rs=null;
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, map.get("id"));
			rs=pst.executeQuery();
			if(rs.next()) {//id 있다면
				if(rs.getString("pass").equals(map.get("pass").toString().trim())) {//비밀번호 비교
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
				
		return false;
	}
	public int memberDelete(String id) {
		int rs=0;
		String sql="DELETE FROM LOGINTEST WHERE ID=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			rs=pst.executeUpdate(); //delete를 못하면 0, delete를 하나하면 1
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	/*public void deleteMember(String id) {
		String sql="DELETE FROM LOGINTEST WHERE ID='"+id+"'";
		try {
			pst=con.prepareStatement(sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
/*	public void modifyMember(String id,String column,String change) {
		String sql="UPDATE LOGINTEST SET "+column+"='"+change+"' WHERE "+column+"='"+id+"'";
		System.out.println(sql);
		try {
			pst=con.prepareStatement(sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	public int modifyMember(LoginMember member) {
		int rs=0;
		try {
			String sql="UPDATE LOGINTEST SET PASS=?,NAME=?,ADDR=? WHERE ID=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, member.getPass());
			pst.setString(2, member.getName());
			pst.setString(3, member.getAddr());
			pst.setString(4, member.getId());
			rs=pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
		
	}
	public LoginMember infoMember(String id) {
		String sql="SELECT * FROM LOGINTEST WHERE ID=?";
		ResultSet rs=null;
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				LoginMember user=new LoginMember();
				user.setId(rs.getString("id"));
				user.setPass(rs.getString("pass"));
				user.setName(rs.getString("name"));
				user.setAddr(rs.getString("addr"));				
				return user;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public void addMember(LoginMember login) {
		String sql="INSERT INTO LOGINTEST VALUES(?,?,?,?)";
		try {
			
			pst=con.prepareStatement(sql);
			pst.setString(1, login.getId());
			pst.setString(2, login.getPass());
			pst.setString(3, login.getName());
			pst.setString(4, login.getAddr());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
