package sist.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

import javax.swing.JTable;

import oracle.security.o3logon.O3LoginClientHelper;
import sist.com.jdbc.JtableModelEx1;
import sist.com.jdbc.app.JTableProcess;
import sist.com.jdbc.app.JdbcProcessEx1;
import sist.com.model.StudentBean;
import sist.service.util.ServiceUtil;

public class StudentDao {
	
	static JtableModelEx1 table;
	
	public static  void selectAccess(JdbcProcessEx1 pr,String sql) {
		Connection con=ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		int row,col;
		Object[][]data;
		try {
			pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=pstmt.executeQuery();
			rs.last();
			row=rs.getRow();
			rsmd=rs.getMetaData();//결과집합에 따라서 메타데이타가 나올 수 있다.
			col=rsmd.getColumnCount();			
			data=new Object[row][col];//메모리가 만들어진다
			rs.beforeFirst();
			int i=0;
			while(rs.next()) {
				for (int j = 0; j < col; j++) {
					data[i][j]=rs.getString(j+1);
				}
				i++;
			}
		    JTableProcess jTableProcess=new JTableProcess(data);
		    String []colName=new String[col];
		    for (int j = 0; j < colName.length; j++) {
				colName[j]=rsmd.getColumnName(j+1);
			}
		    jTableProcess.setColName(colName);
		    pr.getJtable().setModel(jTableProcess);
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
		
		 
   		
	}
	
	
	public static JtableModelEx1 selectInfo(String sql){
		Connection con=ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		Object [][]data=null;
		String []col;
		ResultSet rs=null;
		ResultSetMetaData rsmd;
		try {
			pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=pstmt.executeQuery();
			rsmd=rs.getMetaData();
			rs .last();
			data=new Object[rs.getRow()][rsmd.getColumnCount()];
			rs.beforeFirst();
			int i = 0;
			while (rs.next()) {
		           for (int j = 0; j < rsmd.getColumnCount(); j++) {
		              data[i][j] = rs.getString(j + 1);
		           }
		           i++;
		        }
		    col = new String[rsmd.getColumnCount()];
		        for (int j = 0; j < col.length; j++) {
		           col[j] = rsmd.getColumnName(j + 1);
		    }

			
			table=new JtableModelEx1(data);
			table.setColumnName(col);
			return table;
			
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
		return null;
	}
}
