package sist.com.jdbc;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class MemberView extends JFrame implements ActionListener {
	Panel gridP,postPan,idPan;
	TextField[]tf=new TextField[4];
	TextField idtf;
	
	JButton jbtn,idbtn;	
	
	
	
	public TextField getIdtf() {
		return idtf;
	}
	public void setIdtf(TextField idtf) {
		this.idtf = idtf;
	}
	public TextField[] getTf() {
		return tf;
	}
	public void setTf(TextField[] tf) {
		this.tf = tf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(jbtn==e.getSource()) {
			new PostSearchBox(this);
		}else if(idbtn==e.getSource()) {
			new IdCheckBox(this);
		}
		
	}
	public void initLay() {
		gridP=new Panel(new GridLayout(15, 1));
		idPan=new Panel();
		idPan.add(idtf=new TextField(37));
		idPan.add(idbtn=new JButton("중복검사"));
		idbtn.addActionListener(this);
		
		postPan=new Panel();
		for (int i = 0; i < tf.length; i++) {
			tf[i]=i==0||i==1?new TextField(15):new TextField(50);
		}
		postPan.add(tf[0]);
		tf[0].setEditable(false);
		postPan.add(new Label("-"));
		postPan.add(tf[1]);
		tf[1].setEditable(false);
		postPan.add(jbtn=new JButton("우편번호"));
		jbtn.addActionListener(this);
		gridP.add(idPan);
		gridP.add(postPan);		
		//gridP.add(new JLabel(""));
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		jp1.add(tf[2]);
		jp2.add(tf[3]);
		
		gridP.add(jp1);
		gridP.add(jp2);
		
		this.add(gridP);
	}	
	public MemberView() {
		initLay();
		this.setBounds(300, 100, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MemberView();

	}

}
