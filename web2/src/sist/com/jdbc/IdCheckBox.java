package sist.com.jdbc;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import sist.com.dao.ZipCodeDao;

public class IdCheckBox extends JFrame  {
	private Panel panel,panel2;
	private TextField idTf;
	private JButton search;
	private Label label;
	private boolean flag;
	private MemberView memberView;
	public void initLay() {
		panel2=new Panel(new GridLayout(3,1));
		panel=new Panel();		
		panel.add(idTf=new TextField(20));
		idTf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				idTf.setText("");
				
			}
		});
		panel.add(search=new JButton("Search"));
		search.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag=ZipCodeDao.idCheckBoolean(idTf.getText());
				label.setText(flag?"이미 사용중입니다 다른아이디 검색":"사용가능 여기를 클릭하세요");
				
			}
		});
		
		
		panel2.add(new Label(""));
		panel2.add(panel);
		panel2.add(label=new Label("    ID를 입력하세요 !"));
		label.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(!flag) {
					memberView.getIdtf().setText(idTf.getText());
					IdCheckBox.this.dispose();
				}
			}
			
		});
		this.add("North",panel2);		
	}	
	public IdCheckBox(MemberView memberView) {
		this.memberView=memberView;
		initLay();
		this.setBounds(100, 100, 300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
