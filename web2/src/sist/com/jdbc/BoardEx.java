package sist.com.jdbc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sist.com.dao.BoardExDao;

public class BoardEx extends JFrame implements ActionListener{

	private JTable jtable;
	private JPanel jp,jp2;
	private JScrollPane jsp;
	private TextField tf;
	private JButton jbtn,jbtnWrite,jbtnDelete;
	private JComboBox<String> jcb;
	private String []str= {"글제목","글쓴이","내용"};
	
	
	
	public JTable getJtable() {
		return jtable;
	}

	public void setJtable(JTable jtable) {
		this.jtable = jtable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(jbtnWrite==e.getSource()) {
			new BoardExWrite(this);
		}
	}

	public void initLayEx() {
		jsp=new JScrollPane(jtable=new JTable(),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add("Center",jsp);
		tf=new TextField(30);
		jcb=new JComboBox<String>(str);
		jp=new JPanel();
		jp.add(jcb);
		jp.add(tf);
		jp.add(jbtn=new JButton("검색"));
		jp2=new JPanel(new BorderLayout());
		jp2.add("East",jbtnWrite=new JButton("글쓰기"));
		jp2.add("West",jbtnDelete=new JButton("삭제"));
		jbtnWrite.addActionListener(this);
		this.add("North",jp2);
		this.add("South",jp);
	}

	public BoardEx() {
		initLayEx();
		BoardExDao.getInstance().list(this);
		this.setBounds(100, 100, 600, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new BoardEx();
	} 
}
