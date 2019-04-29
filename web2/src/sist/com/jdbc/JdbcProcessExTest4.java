package sist.com.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sist.com.dao.StudDao;
import sist.com.model.StudentBean;

public class JdbcProcessExTest4 extends JFrame{
	
	private JScrollPane jsp;
	private JtableModelEx jtableModel=new JtableModelEx();
	private JTable jtable;
	private Object [][]data;
	//STUDNO	NAME	USERID	GRADE	IDNUM	BIRTHDATE	TEL	HEIGHT	WEIGHT	DEPTNO	PROFNO	
	public void setTable() {
		List<StudentBean>list=StudDao.selectList();
		data=new Object[jtableModel.getColumnCount()][list.size()];
		for (int i = 0; i < list.size(); i++) {
			int j=0;
			StudentBean sb=list.get(i);
			data[i][j++]=sb.getStudno();
			data[i][j++]=sb.getName();
			data[i][j++]=sb.getUserid();
			data[i][j++]=sb.getGrade();
			data[i][j++]=sb.getIdnum();
			data[i][j++]=sb.getBirthdate();
			data[i][j++]=sb.getTel();
			data[i][j++]=sb.getHeight();
			data[i][j++]=sb.getWeight();
			data[i][j++]=sb.getDeptno();
			data[i][j++]=sb.getProfno();			
		}
		jtableModel.setData(data);
	}
	
	public void initLayEx() {
		setTable();
		jsp=new JScrollPane(jtable=new JTable(jtableModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(jsp);
	}
	
	public JdbcProcessExTest4() {
		initLayEx();
		this.setBounds(10,10,900,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JdbcProcessExTest4();
	}
}
