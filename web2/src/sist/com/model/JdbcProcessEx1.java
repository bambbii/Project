package sist.com.jdbc.app;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import sist.com.dao.StudentDao;
import sist.com.jdbc.JtableModelEx1;

public class JdbcProcessEx1 extends JFrame implements ActionListener{

	private JTextArea jta;
	private JButton jbtn;
	private JTable jtable;
	private JPanel jpan;
	private JtableModelEx1 table;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jbtn) {
			
			jtable.setModel(StudentDao.selectInfo(jta.getText()));
			//StudentDao.selectAccess(this, jta.getText());
		}
	}

	public JTable getJtable() {
		return jtable;
	}

	public void setJtable(JTable jtable) {
		this.jtable = jtable;
	}

	public void initLayEx() {
		jpan=new JPanel();
		jpan.add(new JScrollPane(jta=new JTextArea(5,35),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		jta.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				jbtn.doClick();
			}
			
			
		});
		jpan.add(jbtn=new JButton("Query"));
		jbtn.addActionListener(this);
		jtable=new JTable();
		this.add("North",jpan);
		this.add("South", new JScrollPane(jtable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
	}

	public JdbcProcessEx1() {
		initLayEx();
		this.setBounds(100, 100, 500, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JdbcProcessEx1();
	}
}
