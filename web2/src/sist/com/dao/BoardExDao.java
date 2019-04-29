package sist.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import sist.com.jdbc.BoardEx;
import sist.com.jdbc.app.JtableBoardProcess;
import sist.service.util.ServiceUtil;

public class BoardExDao {
	private static BoardExDao boardExDao;
	private ArrayList<BoardExDao>list;
	
	public static BoardExDao getInstance() {
		if(boardExDao==null) {
			boardExDao=new BoardExDao();
		}
		return boardExDao;
	}
	
	public void list(BoardEx boardEx){//게시판 목록
		Connection con=ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		String sql="Select no,title,writer,hit,regdate from boardex order by no desc";
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		Object [][]data;
		BoardExDao boardExdao=new BoardExDao();
		int col=0;
		int row=0;
		try {
			pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=pstmt.executeQuery();
			rs.last();
			row=rs.getRow();
			rsmd=rs.getMetaData();
			col=rsmd.getColumnCount();
			data=new Object[row][col];
			rs.beforeFirst();
			int i=0;
			while(rs.next()) {
				for (int j = 0; j < col; j++) {
					data[i][j]=rs.getString(j+1);
				}
				i++;
			}
			JtableBoardProcess jtablebp=new JtableBoardProcess(data);
			String []colName=new String[col];
			for (int j = 0; j < colName.length; j++) {
				colName[j]=rsmd.getColumnName(j+1);
			}
			jtablebp.setColumnName(colName);
			boardEx.getJtable().setModel(jtablebp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public void update(BoardEx boardEx,String title,String writer,String contents,String password) {
		Connection con=ServiceUtil.getConnection();
		PreparedStatement pstmt=null;
		String sql="INSERT INTO BOARDEX VALUES(BOARDEX_SEQ.NEXTVAL,?,?,?,?,0,SYSDATE)";
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, contents);
			pstmt.setString(4, password);
			pstmt.executeUpdate();
			con.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
