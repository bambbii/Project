package sist.com.jdbc;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sist.com.dao.ManageDao;
import sist.com.model.ManageInputBean;

public class ManageMain extends JFrame implements ActionListener{
	
	private String []str= {"재고 입고","재고 출고","현 재고 조회","입고 조회","출고 조회"};
	private JPanel []jpn=new JPanel[str.length];
	private JTabbedPane jtp=new JTabbedPane();
	private String []inputStr= {"상품 명","입고 수량","코드 입력","날짜 입력"};
	private JLabel []jlbInput=new JLabel[inputStr.length];
	private JTextField []jtfInput=new JTextField[inputStr.length];
	private String []inJbtnStr= {"재고 등록 내용","코드 등록 내용","등록"};
	private JButton []jbtnInput=new JButton[inJbtnStr.length];
	private JComboBox<String>jcb=new JComboBox<>();
	private JPanel jpn1,jpn2,jpn3;
	private String []codeStr= {"코드 명","코드 타입"};
	private JLabel []jlbCode=new JLabel[codeStr.length];
	private JTextField []jtfCode=new JTextField[codeStr.length];
	private int jpn13=0;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getActionCommand().equals("재고 등록 내용")) {
			jpn1.setVisible(true);
			jpn3.setVisible(false);
			jpn13=0;
			
		}else if(e.getActionCommand().equals("코드 등록 내용")) {
			jpn1.setVisible(false);
			jpn3.setVisible(true);
			jpn13=1;
		}else if(e.getActionCommand().equals("등록")) {
			if(jpn13==0) {//재고 등록 내용을 등록할 떄
				ManageInputBean bean=new ManageInputBean();
				bean.setName(jtfInput[0].getText());//상품명
				//bean.setValue(Integer.parseInt(jtfInput[1].getText()));//입고수량
				//코드
				
				String []data=jcb.getSelectedItem().toString().split(" ");
				
				
				
				//bean.setCode(jcb.getSelectedItem());
				//수량
				//코드입력
				//날짜입력
				//ManageDao.getInstance().inputInventory();
			}else if(jpn13==1) {
				if(jtfCode[0].getText().length()==0||jtfCode[1].getText().length()==0) {
					JOptionPane.showMessageDialog(this,"내용을 입력해주세요");
				}else {
					boolean input=ManageDao.getInstance().inputCode(Integer.parseInt(jtfCode[0].getText()), jtfCode[1].getText());
					if(input) {
						JOptionPane.showMessageDialog(this,"등록되었습니다.");
						jcb.addItem(jtfCode[0].getText()+" "+jtfCode[1].getText());
					}else {
						JOptionPane.showMessageDialog(this, "등록에 실패 하였습니다.");
					}
					for (int i = 0; i < jtfCode.length; i++) {
						jtfCode[i].setText("");
					}
				}
			}
		}
			
	}


	public void initLayEx() {
		for (int i = 0; i < jpn.length; i++) {
			jpn[i]=new JPanel();
			jtp.addTab(str[i], jpn[i]);
		}
		jtp.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				switch (jtp.getSelectedIndex()) {
				case 0:
					ManageMain.this.setBounds(100,100,500,300);
					break;
				case 1:
					ManageMain.this.setBounds(100,100,600,600);
					break;

				default:
					break;
				}
			}
		});
		
		this.add(jtp);
		
		//jpn[0]============재고등록===============
		jpn1=new JPanel(new GridLayout(4, 2));
		jpn2=new JPanel();
		jpn3=new JPanel(new GridLayout(2, 2));
		for (int i = 0; i < inputStr.length; i++) {
			jlbInput[i]=new JLabel(inputStr[i]);
			jpn1.add(jlbInput[i]);
			if(i==2) {
				//콤보박스
				String []comboStr=ManageDao.getInstance().inputCombo();
				jpn1.add(jcb=new JComboBox<String>());
				for (int j = 0; j < comboStr.length; j++) {
					jcb.addItem(comboStr[j]);
				}
			}else {
				jpn1.add(jtfInput[i]=new JTextField(20));
			}
		}
		
		for (int i = 0; i < inJbtnStr.length; i++) {
			jbtnInput[i]=new JButton(inJbtnStr[i]);
			jbtnInput[i].addActionListener(this);
			jpn2.add(jbtnInput[i]);
		}
		
		for (int i = 0; i < codeStr.length; i++) {
			jlbCode[i]=new JLabel(codeStr[i]);
			jpn3.add(jlbCode[i]);
			jpn3.add(jtfCode[i]=new JTextField(20));
		}
		
		jpn[0].add(jpn1);//재고등록
		jpn[0].add(jpn2); //버튼
		jpn[0].add(jpn3);//코드등록
		jpn[0].setLayout(null);
		jpn3.setVisible(false);
		
		jpn1.setBounds(90,80,300,100);
		jpn2.setBounds(0,20,500,50);
		jpn3.setBounds(90,100,300,50);
		
	}
	

	public ManageMain() {
		super("ERP프로그램");
		initLayEx();
		this.setBounds(100, 100, 500, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ManageMain();
	}
}

