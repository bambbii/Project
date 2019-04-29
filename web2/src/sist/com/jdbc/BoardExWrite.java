package sist.com.jdbc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import sist.com.dao.BoardExDao;

public class BoardExWrite extends JFrame implements ActionListener{

	private JLabel []jl=new JLabel[4];
	private String []str= {"TITLE             ","WRITER        ","PASSWORD","CONTENTS"};
	private TextField tf[]=new TextField[3];
	private TextArea ta;
	private JPasswordField jpf;
	private JPanel []jp=new JPanel[4];
	private JPanel back=new JPanel(new GridLayout(3, 1));
	private JScrollPane jsp;
	private JButton jbtn;
	private BoardEx boardEx;

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(jbtn==e.getSource()) {
			BoardExDao.getInstance().update(boardEx,tf[0].getText(), tf[1].getText(), ta.getText(), jpf.getText());
			
		}
	}

	
	public void initLayEx() {
		for (int i = 0; i < jl.length-1; i++) {
			jp[i]=new JPanel(new FlowLayout(FlowLayout.LEFT));
			jp[i].add(jl[i]=new JLabel(str[i]));
		}
		jp[0].add(tf[0]=new TextField(53));
		jp[1].add(tf[1]=new TextField(20));
		jp[2].add(jpf=new JPasswordField(15));
		back.add(jp[0]);
		back.add(jp[1]);
		back.add(jp[2]);
		jsp=new JScrollPane(ta=new TextArea(20,10));
		this.add("North",back);
		this.add("Center",jsp);
		this.add("South", jbtn=new JButton("±Û¾²±â"));
		jbtn.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				BoardExDao.getInstance().list(boardEx);
			}
			
		});
		
		
	}

	public BoardExWrite(BoardEx boardEx) {

		initLayEx();
		this.boardEx = boardEx;
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
	}
}
