package sist.com.ui.login;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class loginWin extends JFrame implements ActionListener{
	private JPanel back,jpn1,jpn2,jpn3,grid1,bordLay1,jpn4,jpn5;
	private ImageIcon icon1=new ImageIcon("C:\\Users\\sist\\Desktop\\backup\\Desktop\\background.jpg");
	private ImageIcon point=new ImageIcon("C:\\Users\\sist\\Desktop\\backup\\Desktop\\\\point.png");
	private ImageIcon loginIcon=new ImageIcon("C:\\Users\\sist\\Desktop\\backup\\Desktop\\\\login_button.png");
	private JTextField idT;
	private JPasswordField pwT;
	private JLabel idL,pwL,joinL,searchL;
	private JButton loginJbn;
	private ArrayList<UserData>list=new ArrayList<UserData>();
	private UserData userInfo=new UserData();
	private final String PATH="e:\\LOGIN.dat";
	
	public int searchMember() {
		String id=idT.getText();
		String pw=pwT.getText();
		for (int i = 0; i < list.size(); i++) {
			if(id.equals(list.get(i).getId())) {
				if(pw.equals(list.get(i).getPw())){
					userInfo=list.get(i);
					System.out.println("id,pw : "+list.get(i).getId()+" "+list.get(i).getPw());
					return 1;//id,pw �� ���� ��
				}else {
					System.out.println("id,pw : "+list.get(i).getId()+"][ "+list.get(i).getPw());
					return 0;//pw�� Ʋ�� ��
				}}
			else if(id.length()==0||pw.length()==0) {
				return 2;
			}
		}
		return -1;//ȸ�������� ���� ��
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==loginJbn) {
			try {
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File(PATH)));
				list=(ArrayList<UserData>)ois.readObject();
				System.out.println(list);
			} catch (Exception e2) {
				// TODO: handle exception
			}finally {
				int temp=searchMember();
				if(temp==1) {
					new ChatWin(userInfo);
					dispose();
				}else if(temp==0){
					JOptionPane.showMessageDialog(this,"���̵� �Ǵ� �н����尡 ���� �ʽ��ϴ�.");
				}else if(temp==-1) {
					JOptionPane.showMessageDialog(this,"ȸ�������� �����ϴ�.");
				}else if(temp==2) {
					JOptionPane.showMessageDialog(this,"���̵� �Ǵ� �н����带 �Է��ϼ���");
				}
			}
		}
	}

	public void initLayEx() {
		jpn1=new JPanel();
		jpn1.add(idL=new JLabel("���̵�       "));
		jpn1.add(idT=new JTextField(11));
		idL.setFont(new Font("�������", Font.PLAIN, 13));
		
		jpn2=new JPanel();
		jpn2.add(pwL=new JLabel("��й�ȣ   "));
		jpn2.add(pwT=new JPasswordField(11));
		pwL.setFont(new Font("�������", Font.PLAIN, 13));
		
		jpn3=new JPanel(new BorderLayout());
		loginJbn=new JButton(loginIcon);
		loginJbn.setBorderPainted(false);
		loginJbn.setContentAreaFilled(false);
		loginJbn.setFocusPainted(false);
		loginJbn.addActionListener(this);
		
		jpn3.add(loginJbn);
		
		grid1=new JPanel(new GridLayout(2, 1));
		grid1.add(jpn1);
		grid1.add(jpn2);
		
		bordLay1=new JPanel(new BorderLayout());
		bordLay1.add("West",grid1);
		bordLay1.add("Center", jpn3);
		
		joinL=new JLabel("���� ����Ŭ�� ���̵� ��������?");
		searchL=new JLabel("����Ŭ�� ���̵�� ��й�ȣ�� �����̳���?");
		
		joinL.setFont(new Font("�������", Font.BOLD, 11));
		searchL.setFont(new Font("�������", Font.BOLD, 11));
		joinL.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new JoinWin();
			}
			
		});
		
		jpn4=new JPanel();
		jpn4.add(joinL);
		
		jpn5=new JPanel();
		jpn5.add(searchL);
		
		
		back=new JPanel(){

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				g.drawImage(icon1.getImage(),0,0,null);
			}
			
		};
		//jp8.setLayout(null);
		//jp1.setOpaque(false);
		back.setLayout(null);
		bordLay1.setOpaque(false);
		grid1.setOpaque(false);
		jpn5.setOpaque(false);
		jpn4.setOpaque(false);
		jpn3.setOpaque(false);
		jpn2.setOpaque(false);
		jpn1.setOpaque(false);	
		back.setBounds(0,0,588,480);
		bordLay1.setBounds(160,180,300,60);
		jpn4.setBounds(140,275,300,50);
		jpn5.setBounds(140,300,300,50);
		this.add(bordLay1);
		this.add(jpn4);
		this.add(jpn5);
		this.add(back);

		
	}
	
	public loginWin() {
		super("����Ŭ�� ŸŰ");
		initLayEx();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			
		});
		
		this.setBounds(100,100,588,480);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new loginWin();
	}
	
}
