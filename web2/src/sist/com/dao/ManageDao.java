package sist.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import sist.com.model.ManageInputBean;
import sist.service.util.ServiceUtil;

public class ManageDao {
	
	private static ManageDao manageDao;
	
	public static ManageDao getInstance() {
		if(manageDao==null) {
			manageDao=new ManageDao();
		}
		return manageDao;
	}
	
	//재고등록
	public void inputInventory(ManageInputBean data) {
		Connection con=ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		String sql="INSERT INTO INVENTORY VALUES(?,?,?,?,SYSDATE)";
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean inputCode(int code,String type) {
		Connection con=ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		String sql="INSERT INTO CODEINVENTORY VALUES(?,?)";
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.setString(2, type);
			pstmt.executeUpdate();
			con.commit();
			return true;
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
		}return false;
	}
	
	
	//재고등록에 코드콤보박스 리스트 가져오기
	public String[] inputCombo() {
		Connection con=ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		String sql="SELECT CONCAT(CONCAT(CODE,' '),CODETYPE) FROM CODEINVENTORY";
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		int col=0,row=0;
		String []str;
		try {
			pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=pstmt.executeQuery();
			rs.last();
			rsmd=rs.getMetaData();
			col=rsmd.getColumnCount();
			row=rs.getRow();
			str=new String[row];
			rs.beforeFirst();
			int i=0;
			while(rs.next()) {
				System.out.println("col"+col+"row"+row);
				String data=new String();
				data+=rs.getString(1);
				System.out.println("rr : "+data);
				str[i]=data;
				i++;
				
			}
			return str;
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
		}return null;
		
	}
	
}
