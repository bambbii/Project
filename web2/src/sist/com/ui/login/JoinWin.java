package sist.com.ui.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinWin extends JFrame implements ActionListener{
	private JPanel back,jpn1,jpn2,jpn3,jpn4,grid,jpn5;
	private ImageIcon joinW=new ImageIcon("C:\\Users\\sist\\Desktop\\backup\\Desktop\\join.jpg");
	private JLabel idL,pwL,nickL,emailL;
	private JPasswordField pwT;
	private JTextField idT,nickT,emailT;
	private JButton joinB,exitB;
	private ArrayList<UserData>list=new ArrayList<UserData>();
	private final String PATH="e:\\LOGIN.dat";
	
	public boolean searchMember() {
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File(PATH)));
			list=(ArrayList<UserData>)ois.readObject();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
			String id=idT.getText();
			String pw=pwT.getText();
			System.out.println("list : "+list);
			
			for (int i = 0; i < list.size(); i++) {
				if(id.equals(list.get(i).getId())) {
					return true;
				}
			}
			
			return false;
		
	}
	
	public void dataWrite(UserData user) {
		try {
		
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File(PATH)));
			oos.writeObject(list);
			JOptionPane.showMessageDialog(this,"회원가입성공");
			System.out.println(list);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==exitB) {
			idT.setText("");
			nickT.setText("");
			emailT.setText("");
			pwT.setText("");
		}else if(e.getSource()==joinB) {
			UserData user=new UserData();
			user.setId(idT.getText());
			user.setPw(pwT.getText());
			user.setNickname(nickT.getText());
			user.setEmail(emailT.getText());
			if(searchMember()) {
				JOptionPane.showMessageDialog(this,"아이디와 패스워드가 있습니다.");
			}else {
				list.add(user);
				dataWrite(user);
				
			}
		}
		
	}
	public void initLayEx() {
		jpn1=new JPanel();
		jpn1.add(idL=new JLabel("아이디      "));
		idL.setFont(new Font("나눔고딕", Font.BOLD, 14));
		jpn1.add(idT=new JTextField(15));
		
		jpn2=new JPanel();
		jpn2.add(pwL=new JLabel("패스워드  "));
		pwL.setFont(new Font("나눔고딕", Font.BOLD, 14));
		jpn2.add(pwT=new JPasswordField(15));
		
		jpn3=new JPanel();
		jpn3.add(nickL=new JLabel("닉네임      "));
		nickL.setFont(new Font("나눔고딕", Font.BOLD, 14));
		jpn3.add(nickT=new JTextField(15));
		
		jpn4=new JPanel();
		jpn4.add(emailL=new JLabel("이메일      "));
		emailL.setFont(new Font("나눔고딕", Font.BOLD, 14));
		jpn4.add(emailT=new JTextField(15));
		
		jpn5=new JPanel();
		jpn5.add(joinB=new JButton("회원가입"));
		joinB.setBackground(Color.white);
		joinB.setFont(new Font("나눔고딕",Font.BOLD,14));
		joinB.addActionListener(this);
		jpn5.add(exitB=new JButton("  취소   "));
		exitB.setBackground(Color.white);
		exitB.setFont(new Font("나눔고딕",Font.BOLD,14));
		exitB.addActionListener(this);
		
		grid=new JPanel(new GridLayout(4, 1));
		grid.add(jpn1);
		grid.add(jpn2);
		grid.add(jpn3);
		grid.add(jpn4);
		
		back=new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				g.drawImage(joinW.getImage(), 0, 0, null);
			}
			
		};
		back.setLayout(null);
		grid.setOpaque(false);
		jpn1.setOpaque(false);
		jpn2.setOpaque(false);
		jpn3.setOpaque(false);
		jpn4.setOpaque(false);
		jpn5.setOpaque(false);
		back.setBounds(0,0,588,600);
		grid.setBounds(-33,200,400,200);
		jpn5.setBounds(-33,480,400,200);
		this.add(jpn5);
		this.add(grid);
		this.add(back);
	}
	public JoinWin() {
		super("세이클럽 회원가입");
		initLayEx();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		this.setBounds(500,100,350,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JoinWin();
	}
}

